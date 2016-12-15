package com.whyalwaysmea.bigboom.view.moviedetail.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;
import com.whyalwaysmea.bigboom.http.exception.ResponeThrowable;
import com.whyalwaysmea.bigboom.rx.RxSubscriber;

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
                .subscribe(new RxSubscriber<Review>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        loadCompleteListener.onLoadFailed(responeThrowable.message);
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
