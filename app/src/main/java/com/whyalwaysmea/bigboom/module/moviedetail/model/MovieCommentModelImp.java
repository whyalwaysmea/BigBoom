package com.whyalwaysmea.bigboom.module.moviedetail.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Comment;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/10/26.
 */

public class MovieCommentModelImp implements IMovieCommentModel {

    private Subscription mSubscribe;

    @Override
    public void loadMovieComments(String id, OnLoadCompleteListener<Comment> loadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscribe = apiManager.getComment(id, Constants.ID.APIKEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Comment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Comment comment) {
                        if(comment.getComments() != null && loadCompleteListener != null) {
                            loadCompleteListener.onLoadSussess(comment);
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
