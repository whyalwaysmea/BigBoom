package com.whyalwaysmea.bigboom.module.movie.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.module.movie.presenter.MovieListPresenterImp;
import com.whyalwaysmea.bigboom.module.movie.ui.adapter.ComingSoonMovieAdapter;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;
import com.whyalwaysmea.bigboom.view.MyRecyclerView;

import java.util.List;

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
    private List<MovieInfo> mMovieInfos;


    @Override
    protected MovieListPresenterImp createPresenter(BaseView view) {
        return new MovieListPresenterImp(this);
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

    }

    @Override
    public void setData(MovieListResponse movieListResponse) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }
}
