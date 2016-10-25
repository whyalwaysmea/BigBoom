package com.whyalwaysmea.bigboom.module.moviedetail.presenter;

import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.module.moviedetail.model.IMovieReviewModel;
import com.whyalwaysmea.bigboom.module.moviedetail.model.MovieReviewModelImp;
import com.whyalwaysmea.bigboom.module.moviedetail.view.IMovieView;
import com.whyalwaysmea.bigboom.utils.NetworkUtils;

/**
 * Created by Long
 * on 2016/10/24.
 */

public class MovieReviewPresenterImp extends BasePresenter<IMovieView> implements IMovieReviewPresenter, OnLoadCompleteListener<Review> {

    private IMovieReviewModel mIMovieReviewModel;

    public MovieReviewPresenterImp(IMovieView iMovieView) {
        super(iMovieView);
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
        mView.setReviewData(review.getReviews());
    }

    @Override
    public void onLoadFailed(String error) {
        mView.hideLoading();
        mView.showToast(error);
    }
}
