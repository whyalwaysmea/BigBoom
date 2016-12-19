package com.whyalwaysmea.bigboom.view.cast.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jakewharton.rxbinding.support.v4.view.RxViewPager;
import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.di.component.DaggerCastComponent;
import com.whyalwaysmea.bigboom.di.module.CastModule;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.utils.DownLoadUtils;
import com.whyalwaysmea.bigboom.utils.PermissionUtil;
import com.whyalwaysmea.bigboom.view.cast.presenter.CastPhotoPresenterImp;
import com.whyalwaysmea.bigboom.view.cast.view.ICastPhotoView;
import com.whyalwaysmea.bigboom.widget.HackyViewPager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;
import uk.co.senab.photoview.PhotoView;

public class PhotoActivity extends  MvpActivity<ICastPhotoView, CastPhotoPresenterImp> implements ICastPhotoView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewPager)
    HackyViewPager mViewPager;

    @Inject
    CastPhotoPresenterImp mPresenter;

    private int mPosition;
    private int totalSize;
    private int start;
    private String mId;

    private PhotoAdapter mPhotoAdapter;
    private CastPhoto mCastPhoto;
    private List<CastPhoto.PhotosBean> mPhotosList;
    private List<CastDetail.PhotosBean> mPhotosBeen;

    private Bitmap mCurrentBitmap;
    private StringBuffer sbDes;

    @Override
    protected CastPhotoPresenterImp createPresenter(BaseView view) {
//        return new CastPhotoPresenterImp(this);
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);

        DaggerCastComponent.builder()
                .castModule(new CastModule(this))
                .build()
                .inject(this);
        init();
    }

    @Override
    protected void initData() {

        mCastPhoto = (CastPhoto) getIntent().getSerializableExtra(Constants.KEY.CAST_PHOTO);
        if(mCastPhoto != null) {
            mPhotosList = new ArrayList<>();
            mPhotosList.addAll(mCastPhoto.getPhotos());
            mId = mCastPhoto.getCelebrity().getId();
        }

        mPhotosBeen = (List<CastDetail.PhotosBean>) getIntent().getSerializableExtra(Constants.KEY.PHOTOT_URL);
        if(mPhotosBeen != null) {
            mPhotosList = new ArrayList<>();
            mCastPhoto = new CastPhoto();
            mCastPhoto.setTotal(mPhotosBeen.size());
            for (CastDetail.PhotosBean photosBean:mPhotosBeen) {
                CastPhoto.PhotosBean photo = new CastPhoto.PhotosBean();
                photo.setImage(photosBean.getImage());
                mPhotosList.add(photo);
            }
        }

        sbDes = new StringBuffer();
        String name = getIntent().getStringExtra(Constants.KEY.CAST_NAME);
        if(TextUtils.isEmpty(name) && mCastPhoto != null) {
            sbDes.append(mCastPhoto.getCelebrity().getName());
        } else if(!TextUtils.isEmpty(name)) {
            sbDes.append(name);
        }

        String castId = getIntent().getStringExtra(Constants.KEY.CASTID);
        if(!TextUtils.isEmpty(castId)) {
            mId = castId;
        }


        mPosition = getIntent().getIntExtra(Constants.KEY.POSITION, 0);
        mViewPager.setAdapter(mPhotoAdapter);
        mViewPager.setCurrentItem(mPosition);
        start = mPhotosList.size();
        totalSize = mPhotosList.size();

        mToolbar.setTitle( "(" + (mPosition + 1 )+ "/" + mCastPhoto.getTotal() + ")");
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);
        RxToolbar.navigationClicks(mToolbar).subscribe(aVoid -> finish());
    }

    @Override
    protected void initView() {
        mToolbar.setBackground(mContext.getResources().getDrawable(R.drawable.toolbar_drak_bg));
        mPhotoAdapter = new PhotoAdapter();
        RxViewPager.pageSelections(mViewPager).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer page) {
                if(mCastPhoto != null) {
                    if( (page + 1) >= totalSize) {
                        mPresenter.getCastPhoto(mId, start);
                    }
                    mToolbar.setTitle("(" + (page + 1 )+ "/" + mCastPhoto.getTotal() + ")");
                }
            }
        });
    }


    @Override
    public void showPhotos(CastPhoto castPhoto) {
        mPhotosList.addAll(castPhoto.getPhotos());
        mPhotoAdapter.notifyDataSetChanged();
        totalSize = mPhotosList.size();
        if(mCastPhoto.getTotal() != castPhoto.getTotal()) {
            mCastPhoto.setTotal(castPhoto.getTotal());
        }
    }

    private class PhotoAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPhotosList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(mContext);

            container.addView(photoView);
            CastPhoto.PhotosBean photosBean = mPhotosList.get(position);
            ImageUtils.getInstance().displayAsBitmap(mContext, photosBean.getImage(), new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    photoView.setImageBitmap(resource);
                    mCurrentBitmap = resource;
                }
            });

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.down, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.download_photo) {
            PermissionUtil.externalStorage(new PermissionUtil.RequestPermission() {
                @Override
                public void onRequestPermissionSuccess() {
                    DownLoadUtils.saveImage(mContext, sbDes.toString() + "(" + (mViewPager.getCurrentItem() + 1) + ")", mCurrentBitmap, new DownLoadUtils.DownloadListener() {
                        @Override
                        public void success() {
                            showSnackbar(mToolbar, getResources().getString(R.string.download_success));
                        }

                        @Override
                        public void failed() {
                            showSnackbar(mToolbar, getResources().getString(R.string.download_failed));
                        }

                        @Override
                        public void exists() {
                            showSnackbar(mToolbar, getResources().getString(R.string.download_exists));
                        }
                    });
                }

                @Override
                public void onRequestPermissionFailed() {

                }
            }, new RxPermissions(this));
        }
        return super.onOptionsItemSelected(item);
    }
}
