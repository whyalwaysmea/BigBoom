package com.whyalwaysmea.bigboom.view.moviedetail.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;
import com.whyalwaysmea.bigboom.http.exception.ResponeThrowable;
import com.whyalwaysmea.bigboom.rx.RxSubscriber;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/10/13.
 */

public class MovieDetailModelImp implements IMovieDetailModel {

    private Subscription mSubscribe;


    @Override
    public void loadSubject(String id, OnLoadCompleteListener<MovieDetail> listener) {
        ApiManager api = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscribe = api.getSubject(id, Constants.ID.APIKEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscriber<MovieDetail>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        listener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(MovieDetail movieDetail) {
                        if (null != listener) {
                            listener.onLoadSussess(movieDetail);
                        }
                    }
                });
    }


    @Override
    public void onDestroy() {
        if(mSubscribe != null && mSubscribe.isUnsubscribed()) {
            mSubscribe.unsubscribe();
        }
    }
}
