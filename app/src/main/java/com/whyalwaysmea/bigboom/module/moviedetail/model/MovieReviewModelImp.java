package com.whyalwaysmea.bigboom.module.moviedetail.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/10/24.
 */

public class MovieReviewModelImp implements IMovieReviewModel {

    private Subscription mSubscription;

    @Override
    public void onDestroy() {
        if(mSubscription != null && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void loadMovieReview(String id, OnLoadCompleteListener<Review> loadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscription = apiManager.getReview(id, Constants.ID.APIKEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Review>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(loadCompleteListener != null) {
                            loadCompleteListener.onLoadFailed(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(Review review) {
                        if(review.getTotal() > 0 && loadCompleteListener != null) {
                            loadCompleteListener.onLoadSussess(review);
                        }
                    }
                });
    }
}
