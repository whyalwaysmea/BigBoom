package com.whyalwaysmea.bigboom.view.movielist.presenter;

import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;
import com.whyalwaysmea.bigboom.view.movielist.model.IMovieListModel;
import com.whyalwaysmea.bigboom.view.movielist.model.MovieListModelImp;
import com.whyalwaysmea.bigboom.view.movielist.view.IWeeklyMoviesView;
import com.whyalwaysmea.bigboom.utils.NetworkUtils;

/**
 * Created by Long
 * on 2016/9/15.
 */
public class WeeklyMoviePresenterImp extends BasePresenter<IWeeklyMoviesView> implements IWeeklyMoviePresenter, OnLoadCompleteListener<WeeklyMovieInfo> {

    private IMovieListModel mMovieListModel;

    public WeeklyMoviePresenterImp(IWeeklyMoviesView iWeeklyMoviesView) {
        super(iWeeklyMoviesView);
        mMovieListModel = new MovieListModelImp();
    }

    @Override
    public void loadWeekly() {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        }
        mView.showLoading();
        mMovieListModel.loadWeeklyMovies(this);
    }

    @Override
    public void loadNewMovies() {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        }
        mView.showLoading();
        mMovieListModel.loadNewMovies(new OnLoadCompleteListener<MovieListResponse>() {
            @Override
            public void onLoadSussess(MovieListResponse movieListResponse) {
                mView.hideLoading();
                mView.setNewMoviesData(movieListResponse);
            }

            @Override
            public void onLoadFailed(String error) {
                mView.hideLoading();
                mView.showToast(error);
            }
        });
    }


    @Override
    public void onLoadSussess(WeeklyMovieInfo weeklyMovieInfo) {
        mView.hideLoading();
        mView.setWeeklyData(weeklyMovieInfo);
    }

    @Override
    public void onLoadFailed(String error) {
        mView.hideLoading();
        mView.showToast(error);
    }
}
