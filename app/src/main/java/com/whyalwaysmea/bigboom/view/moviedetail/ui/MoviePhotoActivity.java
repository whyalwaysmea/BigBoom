package com.whyalwaysmea.bigboom.view.moviedetail.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.MoviePhoto;
import com.whyalwaysmea.bigboom.di.component.DaggerMovieComponent;
import com.whyalwaysmea.bigboom.di.module.MovieModule;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.presenter.MoviePhotoListPresenterImp;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMoviePhotoListView;
import com.whyalwaysmea.bigboom.utils.DownLoadUtils;
import com.whyalwaysmea.bigboom.widget.HackyViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

public class MoviePhotoActivity extends MvpActivity<IMoviePhotoListView, MoviePhotoListPresenterImp> implements IMoviePhotoListView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewPager)
    HackyViewPager mViewPager;

    private String mMovieId;
    private MoviePhoto mMoviePhoto;
    private Bitmap mCurrentBitmap;
    private PhotoAdapter mPhotoAdapter;
    private int start;
    private int position;
    private StringBuffer sbDes;

    @Inject
    MoviePhotoListPresenterImp mPresenter;

    @Override
    protected MoviePhotoListPresenterImp createPresenter(BaseView view) {
//        return new MoviePhotoListPresenterImp(this);
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);

        DaggerMovieComponent
                .builder()
                .movieModule(new MovieModule(this))
                .build()
                .inject(this);

        init();
    }

    @Override
    protected void initView() {
        mToolbar.setBackground(mContext.getResources().getDrawable(R.drawable.toolbar_drak_bg));
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        mToolbar.setNavigationOnClickListener(v -> finish());
        mPhotoAdapter = new PhotoAdapter();
        mViewPager.setAdapter(mPhotoAdapter);
    }

    @Override
    protected void initData() {

        sbDes = new StringBuffer();
        mMovieId = getIntent().getStringExtra(Constants.KEY.ID);
        position = getIntent().getIntExtra(Constants.KEY.POSITION, 0);
        mPresenter.getMoviePhotoList(mMovieId, start);
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void showMoviePhotoList(MoviePhoto moviePhoto) {
        mMoviePhoto = moviePhoto;
        mPhotoAdapter.notifyDataSetChanged();
        mToolbar.setTitle(mMoviePhoto.getSubject().getTitle());
        if(sbDes.length() == 0) {
            sbDes.append(mMoviePhoto.getSubject().getTitle());
        }
    }

    private class PhotoAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if(mMoviePhoto == null) {
                return 0;
            }
            return mMoviePhoto.getCount();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(mContext);

            container.addView(photoView);
            MoviePhoto.PhotosBean photosBean = mMoviePhoto.getPhotos().get(position);
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

        return super.onOptionsItemSelected(item);
    }
}
