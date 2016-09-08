package com.whyalwaysmea.bigboom.module.movie.presenter;

import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Movie;
import com.whyalwaysmea.bigboom.module.movie.model.IMovieListModel;
import com.whyalwaysmea.bigboom.module.movie.model.MovieListModelImp;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;
import com.whyalwaysmea.bigboom.utils.NetworkUtils;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListPresenterImp extends BasePresenter<IMovieListView> implements IMovieListPresenter, OnLoadCompleteListener<Movie> {

    private IMovieListModel mMovieListModel;

    public MovieListPresenterImp(IMovieListView iMovieListView) {
        super(iMovieListView);
        mMovieListModel = new MovieListModelImp();
    }


    @Override
    public void load(int start, int count) {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        } else {
            mView.showLoading();
            mMovieListModel.load(start, count, this);
        }
    }

    @Override
    public void onLoadSussess(Movie movie) {
        mView.hideLoading();
        mView.setData(movie);
    }

    @Override
    public void onLoadFailed(String error) {
        mView.hideLoading();
        mView.showToast(error);
    }
}
