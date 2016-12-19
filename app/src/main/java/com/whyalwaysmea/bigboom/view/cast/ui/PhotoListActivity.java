package com.whyalwaysmea.bigboom.view.cast.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.di.component.DaggerCastComponent;
import com.whyalwaysmea.bigboom.di.module.CastModule;
import com.whyalwaysmea.bigboom.view.cast.presenter.CastPhotoPresenterImp;
import com.whyalwaysmea.bigboom.view.cast.ui.adapter.PhotoAdapter;
import com.whyalwaysmea.bigboom.view.cast.view.ICastPhotoView;
import com.whyalwaysmea.bigboom.rx.RxBus;
import com.whyalwaysmea.bigboom.service.ImageService;
import com.whyalwaysmea.bigboom.widget.GridMarginDecoration;
import com.whyalwaysmea.bigboom.widget.MyRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class PhotoListActivity extends MvpActivity<ICastPhotoView, CastPhotoPresenterImp> implements ICastPhotoView, MyRecyclerView.OnLoadMoreListener {

    @Inject
    CastPhotoPresenterImp mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.photos_recyclerview)
    MyRecyclerView mPhotosRecyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;
    @BindView(R.id.activity_photo_list)
    LinearLayout mActivityPhotoList;

    private int start;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private String mId;
    private PhotoAdapter mPhotoAdapter;
    private CastPhoto mCastPhoto;

    private CompositeSubscription rxSubscriptions = new CompositeSubscription();

    @Override
    protected CastPhotoPresenterImp createPresenter(BaseView view) {
//        return new CastPhotoPresenterImp(this);
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
        ButterKnife.bind(this);

        DaggerCastComponent.builder()
                .castModule(new CastModule(this))
                .build()
                .inject(this);

        init();
    }

    @Override
    protected void initData() {
        mId = getIntent().getStringExtra(Constants.KEY.CASTID);
        mPresenter.getCastPhoto(mId, start);

        mPhotoAdapter = new PhotoAdapter(this);
        mPhotosRecyclerview.setAdapter(mPhotoAdapter);
        mPhotoAdapter.setOnClickListener((view, position) -> {
            Intent intent = new Intent(mContext, PhotoActivity.class);
            intent.putExtra(Constants.KEY.CAST_PHOTO, mCastPhoto);
            intent.putExtra(Constants.KEY.POSITION, position);
            mContext.startActivity(intent);
        });
        subscribeDownloadEvent();

    }

    @Override
    protected void initView() {
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mPhotosRecyclerview.setLayoutManager(mStaggeredGridLayoutManager);
        mPhotosRecyclerview.setOnLoadMoreListener(this);
        mPhotosRecyclerview.addItemDecoration(new GridMarginDecoration(getResources().getDimensionPixelSize(R.dimen.gridlayout_margin_decoration2)));

        mSwiperefreshlayout.setEnabled(false);

        String castName = getIntent().getStringExtra(Constants.KEY.CAST_NAME);
        if (!TextUtils.isEmpty(castName)) {
            mToolbar.setTitle(castName);
            mToolbar.setNavigationIcon(R.drawable.icon_back);
            setSupportActionBar(mToolbar);
            RxToolbar.navigationClicks(mToolbar).subscribe(aVoid -> finish());

        }
    }


    @Override
    public void showPhotos(CastPhoto castPhoto) {
        if(start == 0) {
            mCastPhoto = castPhoto;
        } else {
            List<CastPhoto.PhotosBean> photos = mCastPhoto.getPhotos();
            photos.addAll(castPhoto.getPhotos());
            mCastPhoto.setPhotos(photos);
        }

        Intent intent = new Intent(this, ImageService.class);
        intent.putExtra(Constants.KEY.CAST_PHOTO, castPhoto);
        startService(intent);


    }

    private void subscribeDownloadEvent() {
        rxSubscriptions.add(RxBus.getInstance().toObservable(CastPhoto.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CastPhoto>() {
                    @Override
                    public void call(CastPhoto castPhoto) {
                        mPhotoAdapter.addData(castPhoto.getPhotos());
                        if (start != 0 ) {
                            mPhotosRecyclerview.enableLoadMore();
                        }
                    }
                }));
    }


    @Override
    public void showLoading() {
        super.showLoading();
        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(true));
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(false));

    }

    @Override
    public void onLoadMore() {
        start += 20;
        mPresenter.getCastPhoto(mId, start);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!rxSubscriptions.isUnsubscribed()) {
            rxSubscriptions.unsubscribe();
        }
    }
}
