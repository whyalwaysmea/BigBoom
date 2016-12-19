package com.whyalwaysmea.bigboom.view.moviedetail.presenter;

import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.view.moviedetail.model.IMovieDetailModel;
import com.whyalwaysmea.bigboom.view.moviedetail.model.MovieDetailModelImp;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieDetailView;
import com.whyalwaysmea.bigboom.utils.NetworkUtils;

import javax.inject.Inject;

/**
 * Created by Long
 * on 2016/9/20.
 */
public class MovieDetailPresenterImp extends BasePresenter<IMovieDetailView> implements IMovieDetailPresenter, OnLoadCompleteListener<MovieDetail> {

    private IMovieDetailModel mIMovieDetailModel;

    @Inject
    public MovieDetailPresenterImp(IMovieDetailView iMovieDetailView) {
        super(iMovieDetailView);
        mIMovieDetailModel = new MovieDetailModelImp();
    }

    @Override
    public void loadSubject(String id) {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        }
        mView.showLoading();
        mIMovieDetailModel.loadSubject(id, this);
    }

    @Override
    public void onLoadSussess(MovieDetail movieDetail) {
        mView.hideLoading();
        mView.setDetailData(movieDetail);
    }

    @Override
    public void onLoadFailed(String error) {
    }
}
