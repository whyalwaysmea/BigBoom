package com.whyalwaysmea.bigboom.view.movielist.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.di.component.DaggerMovieListComponent;
import com.whyalwaysmea.bigboom.di.module.MovieListModule;
import com.whyalwaysmea.bigboom.view.movielist.presenter.MovieListPresenterImp;
import com.whyalwaysmea.bigboom.view.movielist.ui.adapter.ComingSoonMovieAdapter;
import com.whyalwaysmea.bigboom.view.movielist.view.IMovieListView;
import com.whyalwaysmea.bigboom.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/12.
 */
public class ComingSoonFragment extends MvpFragment<IMovieListView, MovieListPresenterImp> implements IMovieListView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerview)
    MyRecyclerView mRecyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private LinearLayoutManager mLayoutManager;
    private ComingSoonMovieAdapter mComingSoonMovieAdapter;
    private List<MovieInfo> mMovieInfoList;

    @Inject
    MovieListPresenterImp mPresenter;

    public static ComingSoonFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ComingSoonFragment fragment = new ComingSoonFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected MovieListPresenterImp createPresenter(BaseView view) {

        DaggerMovieListComponent.builder()
                .movieListModule(new MovieListModule(this))
                .build()
                .inject(this);

        return null;
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.material_amber_500, R.color.material_blue_500,
                R.color.material_cyan_500, R.color.material_deep_purple_500);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    @Override
    protected void initData() {
        mMovieInfoList = new ArrayList<>();
        mComingSoonMovieAdapter = new ComingSoonMovieAdapter(mContext, true);
        mRecyclerView.setAdapter(mComingSoonMovieAdapter);
        onRefresh();
    }

    @Override
    public void setData(MovieListResponse movieListResponse) {
        mMovieInfoList = movieListResponse.getSubjects();
        mComingSoonMovieAdapter.addData(mMovieInfoList);
    }

    @Override
    public void onRefresh() {
        mPresenter.loadComingSoon(0,20);
    }

    @Override
    public void hideLoading() {
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(false));
    }

    @Override
    public void showLoading() {
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(true));
    }
}
