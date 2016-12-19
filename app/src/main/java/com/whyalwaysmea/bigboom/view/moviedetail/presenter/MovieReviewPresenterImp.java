package com.whyalwaysmea.bigboom.view.moviedetail.presenter;

import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.view.moviedetail.model.IMovieReviewModel;
import com.whyalwaysmea.bigboom.view.moviedetail.model.MovieReviewModelImp;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieReviewView;
import com.whyalwaysmea.bigboom.utils.NetworkUtils;

import javax.inject.Inject;

/**
 * Created by Long
 * on 2016/10/24.
 */

public class MovieReviewPresenterImp extends BasePresenter<IMovieReviewView> implements IMovieReviewPresenter, OnLoadCompleteListener<Review> {

    private IMovieReviewModel mIMovieReviewModel;

    @Inject
    public MovieReviewPresenterImp(IMovieReviewView iMovieReviewView) {
        super(iMovieReviewView);
        mIMovieReviewModel = new MovieReviewModelImp();
    }

    @Override
    public void getReview(String id) {
        if(!NetworkUtils.isConnected(App.getApplication())) {
            mView.hideLoading();
            mView.showToast(App.getApplication().getResources().getString(R.string.no_network));
        }
        mView.showLoading();
        mIMovieReviewModel.loadMovieReview(id, this);
    }

    @Override
    public void onLoadSussess(Review review) {
        mView.hideLoading();
        mView.setReviewData(review);
    }

    @Override
    public void onLoadFailed(String error) {
        mView.hideLoading();
        mView.showToast(error);
    }
}
