package com.whyalwaysmea.bigboom.view.movielist.presenter;

import android.support.annotation.Nullable;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.view.movielist.model.IMovieListModel;
import com.whyalwaysmea.bigboom.view.movielist.model.MovieListModelImp;
import com.whyalwaysmea.bigboom.view.movielist.view.IMovieListView;

import javax.inject.Inject;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListPresenterImp extends BasePresenter<IMovieListView> implements IMovieListPresenter, OnLoadCompleteListener<MovieListResponse> {

    private IMovieListModel mMovieListModel;

    @Inject
    public MovieListPresenterImp(IMovieListView iMovieListView) {
        super(iMovieListView);
        mMovieListModel = new MovieListModelImp();
    }


    @Override
    public void loadTop250(int start, int count) {
        mView.showLoading();
        mMovieListModel.loadTop250(start, count, this);

    }

    @Override
    public void loadInTheaters(@Nullable String city) {
        mView.showLoading();
        mMovieListModel.loadInTheaters(city, this);

    }

    @Override
    public void loadComingSoon(int start, int count) {
        mView.showLoading();
        mMovieListModel.loadComingSoon(start, count, this);

    }

    @Override
    public void getSearchMovieList(int start, String keyWords) {
        mView.showLoading();
        mMovieListModel.getSearchMovieList(start, keyWords, this);
    }

    @Override
    public void onLoadSussess(MovieListResponse movieInfo) {
        if(mView != null) {
            mView.hideLoading();
            mView.setData(movieInfo);
        }
    }


    @Override
    public void onLoadFailed(String error) {
        if(mView != null) {
            mView.hideLoading();
            mView.showToast(error);
        }
    }
}
