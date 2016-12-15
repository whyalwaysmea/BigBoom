package com.whyalwaysmea.bigboom.view.movielist.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;
import com.whyalwaysmea.bigboom.view.movielist.presenter.WeeklyMoviePresenterImp;
import com.whyalwaysmea.bigboom.view.movielist.ui.adapter.NewMoviesAdapter;
import com.whyalwaysmea.bigboom.view.movielist.view.IWeeklyMoviesView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/15.
 */
public class WeeklyMovieFragment extends MvpFragment<IWeeklyMoviesView, WeeklyMoviePresenterImp> implements IWeeklyMoviesView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private GridLayoutManager mLayoutManager;
    private List<WeeklyMovieInfo.SubjectsBean> mWeeklyMovieInfos;
    private List<MovieInfo> mNewMoviesInfos;
    private NewMoviesAdapter mNewMoviesAdapter;

    public static WeeklyMovieFragment newInstance() {

        Bundle args = new Bundle();

        WeeklyMovieFragment fragment = new WeeklyMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected WeeklyMoviePresenterImp createPresenter(BaseView view) {
        return new WeeklyMoviePresenterImp(this);
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_weekly_movies, container, false);
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.material_amber_500, R.color.material_blue_500,
                R.color.material_cyan_500, R.color.material_deep_purple_500);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLayoutManager = new GridLayoutManager(getContext(), 1);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    protected void initData() {
        mNewMoviesInfos = new ArrayList<>();
        mWeeklyMovieInfos = new ArrayList<>();
        mNewMoviesAdapter = new NewMoviesAdapter(mContext, mWeeklyMovieInfos, mNewMoviesInfos);
        mRecyclerView.setAdapter(mNewMoviesAdapter);
        onRefresh();

    }

    @Override
    public void onRefresh() {
        mPresenter.loadWeekly();
        mPresenter.loadNewMovies();
    }

    @Override
    public void showLoading() {
        super.showLoading();
        mSwipeRefreshLayout.post(() ->mSwipeRefreshLayout.setRefreshing(true));
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        mSwipeRefreshLayout.post(() ->mSwipeRefreshLayout.setRefreshing(false));
    }

    @Override
    public void setWeeklyData(WeeklyMovieInfo weeklyMovieInfo) {
        mNewMoviesAdapter.addWeeklyMovies(weeklyMovieInfo.getSubjects());
    }

    @Override
    public void setNewMoviesData(MovieListResponse movieListResponse) {
        mNewMoviesAdapter.addNewMovies(movieListResponse.getSubjects());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mNewMoviesAdapter != null)  {
            mNewMoviesAdapter.unRegist();
        }
    }
}
