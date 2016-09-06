package com.whyalwaysmea.bigboom.module.movie.ui;

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
import com.whyalwaysmea.bigboom.bean.Movie;
import com.whyalwaysmea.bigboom.module.movie.presenter.MovieListPresenterImp;
import com.whyalwaysmea.bigboom.module.movie.ui.adapter.HotMovieAdapter;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListFragment extends MvpFragment<IMovieListView, MovieListPresenterImp> implements IMovieListView{


    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private GridLayoutManager mLayoutManager;
    private MovieListPresenterImp mMovieListPresenter;
    private List<String> hotMovies;
    private HotMovieAdapter mHotMovieAdapter;


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

        mLayoutManager = new GridLayoutManager(getContext(), 1);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        hotMovies = new ArrayList<>();
        mHotMovieAdapter = new HotMovieAdapter(getContext(), hotMovies);
        mRecyclerView.setAdapter(mHotMovieAdapter);
    }

    @Override
    protected void initData() {
        mMovieListPresenter.load();
    }


    @Override
    public void refreshData(Movie movie) {
        for (int i = 0; i < movie.getSubjects().size(); i++) {
            hotMovies.add(movie.getSubjects().get(i).getTitle());
        }
        mHotMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void addData(Movie movie) {

    }
}
