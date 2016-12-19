package com.whyalwaysmea.bigboom.view.moviedetail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.MoviePhoto;
import com.whyalwaysmea.bigboom.di.component.DaggerMovieComponent;
import com.whyalwaysmea.bigboom.di.module.MovieModule;
import com.whyalwaysmea.bigboom.view.moviedetail.presenter.MoviePhotoListPresenterImp;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter.MoviePhotoListAdapter;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMoviePhotoListView;
import com.whyalwaysmea.bigboom.widget.GridMarginDecoration;
import com.whyalwaysmea.bigboom.widget.MyRecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviePhotoListActivity extends MvpActivity<IMoviePhotoListView, MoviePhotoListPresenterImp> implements IMoviePhotoListView, MyRecyclerView.OnLoadMoreListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.movie_photo_recyclerview)
    MyRecyclerView mMoviePhotoRecyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;

    private GridLayoutManager mGridLayoutManager;
    private MoviePhotoListAdapter mMoviePhotoListAdapter;
    private String mMovieId;
    private int start;

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
        setContentView(R.layout.activity_movie_photo_list);
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
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mMoviePhotoRecyclerview.setLayoutManager(mGridLayoutManager);
        mMoviePhotoRecyclerview.setOnLoadMoreListener(this);
        mMoviePhotoRecyclerview.addItemDecoration(new GridMarginDecoration(mContext.getResources().getDimensionPixelSize(R.dimen.gridlayout_margin_decoration2)));
        mMoviePhotoListAdapter = new MoviePhotoListAdapter(this, true);
        mMoviePhotoRecyclerview.setAdapter(mMoviePhotoListAdapter);
        mMoviePhotoListAdapter.setOnClickListener((view, position) -> {
            Intent intent = new Intent(mContext, MoviePhotoActivity.class);
            intent.putExtra(Constants.KEY.ID, mMovieId);
            intent.putExtra(Constants.KEY.POSITION, position);
            mContext.startActivity(intent);
        });
        mSwiperefreshlayout.setEnabled(false);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initData() {
        mMovieId = getIntent().getStringExtra(Constants.KEY.ID);
        mPresenter.getMoviePhotoList(mMovieId, start);
    }


    @Override
    public void showMoviePhotoList(MoviePhoto moviePhoto) {
        mMoviePhotoListAdapter.addData(moviePhoto.getPhotos());
        if(start == 0) {
            mToolbar.setTitle(moviePhoto.getSubject().getTitle());
        }
        if((start + moviePhoto.getCount()) <= moviePhoto.getTotal()) {
            mMoviePhotoRecyclerview.enableLoadMore();
        }
    }

    @Override
    public void onLoadMore() {
        start += 20;
        mPresenter.getMoviePhotoList(mMovieId, start);
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
}
