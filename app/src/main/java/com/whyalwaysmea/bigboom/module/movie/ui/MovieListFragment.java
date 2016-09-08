package com.whyalwaysmea.bigboom.module.movie.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.socks.library.KLog;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.Movie;
import com.whyalwaysmea.bigboom.module.movie.presenter.MovieListPresenterImp;
import com.whyalwaysmea.bigboom.module.movie.ui.adapter.HotMovieAdapter;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;
import com.whyalwaysmea.bigboom.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListFragment extends MvpFragment<IMovieListView, MovieListPresenterImp> implements IMovieListView, SwipeRefreshLayout.OnRefreshListener, MyRecyclerView.OnLoadMoreListener {


    @BindView(R.id.recyclerview)
    MyRecyclerView mRecyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private GridLayoutManager mLayoutManager;
    private MovieListPresenterImp mMovieListPresenter;
    private List<String> hotMovies;
    private HotMovieAdapter mHotMovieAdapter;
    private int start = 1;
    private int count = 20;


    public static MovieListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    protected MovieListPresenterImp createPresenter(BaseView view) {
        mMovieListPresenter = new MovieListPresenterImp(this);
        return mMovieListPresenter;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.material_amber_500, R.color.material_blue_500,
                R.color.material_cyan_500, R.color.material_deep_purple_500);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLayoutManager = new GridLayoutManager(getContext(), 1);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        hotMovies = new ArrayList<>();
        mHotMovieAdapter = new HotMovieAdapter(getContext(), hotMovies);
        mRecyclerView.setAdapter(mHotMovieAdapter);
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        onRefresh();
    }


    @Override
    public void setData(Movie movie) {
        if(start == 1) {
            hotMovies.clear();
        }
        for (int i = 0; i < movie.getSubjects().size(); i++) {
            KLog.e(movie.getSubjects().get(i).getTitle() + "...................." + i);
            hotMovies.add(movie.getSubjects().get(i).getTitle());
        }
        mHotMovieAdapter.notifyDataSetChanged();
        start = start * count + 1;
    }


    @Override
    public void onRefresh() {
        start = 1;
        mMovieListPresenter.load(start, count);
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
    public void onLoadMore() {
        if(!mSwipeRefreshLayout.isRefreshing()) {
            mMovieListPresenter.load(start, count);
        }
    }
}
