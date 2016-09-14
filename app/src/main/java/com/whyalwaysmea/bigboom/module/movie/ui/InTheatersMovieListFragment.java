package com.whyalwaysmea.bigboom.module.movie.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.module.movie.presenter.MovieListPresenterImp;
import com.whyalwaysmea.bigboom.module.movie.ui.adapter.InTheatersMovieAdapter;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;
import com.whyalwaysmea.bigboom.view.GridMarginDecoration;
import com.whyalwaysmea.bigboom.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/9.
 */
public class InTheatersMovieListFragment extends MvpFragment<IMovieListView, MovieListPresenterImp> implements IMovieListView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerview)
    MyRecyclerView mRecyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;


    private MovieListPresenterImp mMovieListPresenterImp;
    private GridLayoutManager mLayoutManager;
    private List<MovieInfo> mMovieInfos;
    private InTheatersMovieAdapter mInTheatersMovieAdapter;

    public static InTheatersMovieListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        InTheatersMovieListFragment fragment = new InTheatersMovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    protected MovieListPresenterImp createPresenter(BaseView view) {
        mMovieListPresenterImp = new MovieListPresenterImp(this);
        return mMovieListPresenterImp;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.material_amber_500, R.color.material_blue_500,
                R.color.material_cyan_500, R.color.material_deep_purple_500);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLayoutManager = new GridLayoutManager(mContext, 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position % 6) {
                    case 5:
                        return 3;
                    case 3:
                        return 2;
                    default:
                        return 1;
                }
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridMarginDecoration(mContext.getResources().getDimensionPixelSize(R.dimen.gridlayout_margin_decoration)));

    }

    @Override
    protected void initData() {
        mMovieInfos = new ArrayList<>();
        mInTheatersMovieAdapter = new InTheatersMovieAdapter(mContext, mMovieInfos);
        mRecyclerView.setAdapter(mInTheatersMovieAdapter);
        onRefresh();
    }

    @Override
    public void setData(MovieListResponse movieListResponse) {
        mInTheatersMovieAdapter.addData(movieListResponse.getSubjects());
    }


    @Override
    public void onRefresh() {
        mMovieListPresenterImp.loadInTheaters(null);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(true));
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(false));
    }
}