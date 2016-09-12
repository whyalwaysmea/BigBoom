package com.whyalwaysmea.bigboom.module.movie.presenter;

import android.support.annotation.Nullable;

import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.module.movie.model.IMovieListModel;
import com.whyalwaysmea.bigboom.module.movie.model.MovieListModelImp;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;
import com.whyalwaysmea.bigboom.utils.NetworkUtils;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListPresenterImp extends BasePresenter<IMovieListView> implements IMovieListPresenter, OnLoadCompleteListener<MovieListResponse> {

    private IMovieListModel mMovieListModel;

    public MovieListPresenterImp(IMovieListView iMovieListView) {
        super(iMovieListView);
        mMovieListModel = new MovieListModelImp();
    }


    @Override
    public void loadTop250(int start, int count) {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        } else {
            mView.showLoading();
            mMovieListModel.loadTop250(start, count, this);
        }
    }

    @Override
    public void loadInTheaters(@Nullable String city) {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        } else {
            mView.showLoading();
            mMovieListModel.loadInTheaters(city, this);
        }
    }

    @Override
    public void loadComingSoon(int start, int count) {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        } else {
            mView.showLoading();
            mMovieListModel.loadComingSoon(start, count, this);
        }
    }

    @Override
    public void onLoadSussess(MovieListResponse movieInfo) {
        mView.hideLoading();
        mView.setData(movieInfo);
    }


    @Override
    public void onLoadFailed(String error) {
        mView.hideLoading();
        mView.showToast(error);
    }
}
