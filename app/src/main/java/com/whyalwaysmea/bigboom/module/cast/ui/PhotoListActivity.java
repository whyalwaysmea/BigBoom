package com.whyalwaysmea.bigboom.module.cast.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.module.cast.presenter.CastPhotoPresenterImp;
import com.whyalwaysmea.bigboom.module.cast.view.ICastPhotoView;
import com.whyalwaysmea.bigboom.view.MyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoListActivity extends MvpActivity<ICastPhotoView, CastPhotoPresenterImp> implements ICastPhotoView, MyRecyclerView.OnLoadMoreListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.photos_recyclerview)
    MyRecyclerView mPhotosRecyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;
    @BindView(R.id.activity_photo_list)
    LinearLayout mActivityPhotoList;

    private int start;
    private GridLayoutManager mGridLayoutManager;
    private String mId;

    @Override
    protected CastPhotoPresenterImp createPresenter(BaseView view) {
        return new CastPhotoPresenterImp(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
        ButterKnife.bind(this);

        init();
    }

    @Override
    protected void initData() {
        mId = getIntent().getStringExtra(Constants.KEY.CASTID);
        mPresenter.getCastPhoto(mId, start);
    }

    @Override
    protected void initView() {
        mGridLayoutManager = new GridLayoutManager(this, 3);
        mPhotosRecyclerview.setLayoutManager(mGridLayoutManager);
        mPhotosRecyclerview.setOnLoadMoreListener(this);

        String castName = getIntent().getStringExtra(Constants.KEY.CAST_NAME);


    }


    @Override
    public void showPhotos(CastPhoto castPhoto) {

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

    }
}
