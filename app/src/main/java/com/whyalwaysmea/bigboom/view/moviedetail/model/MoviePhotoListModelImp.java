package com.whyalwaysmea.bigboom.view.moviedetail.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MoviePhoto;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;
import com.whyalwaysmea.bigboom.http.exception.ResponeThrowable;
import com.whyalwaysmea.bigboom.rx.RxSubscriber;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/11/11.
 */

public class MoviePhotoListModelImp implements IMoviePhotoListModel {


    private Subscription mMoviePhoto;

    @Override
    public void getMoviePhotoList(String id, int start, OnLoadCompleteListener<MoviePhoto> completeListener) {
        ApiManager service = HttpMethods.createService();
        mMoviePhoto = service.getMoviePhoto(id, start, Constants.ID.APIKEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscriber<MoviePhoto>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        completeListener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(MoviePhoto moviePhoto) {
                        if(completeListener != null && moviePhoto.getTotal() > 0) {
                            completeListener.onLoadSussess(moviePhoto);
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        if(mMoviePhoto != null && mMoviePhoto.isUnsubscribed()) {
            mMoviePhoto.unsubscribe();
        }
    }
}
