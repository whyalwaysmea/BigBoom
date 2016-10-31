package com.whyalwaysmea.bigboom.module.moviedetail.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastPhotoModelImp implements ICastPhotoModel {

    private Subscription mCastPhoto;

    @Override
    public void loadCastPhoto(String id, int start, OnLoadCompleteListener<CastPhoto> photoOnLoadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService();
        Observable<CastPhoto> castPhoto = apiManager.getCastPhoto(id, start, Constants.ID.APIKEY);
        mCastPhoto = castPhoto.subscribe(new Subscriber<CastPhoto>() {
            @Override
            public void onCompleted() {


            }

            @Override
            public void onError(Throwable e) {
                photoOnLoadCompleteListener.onLoadFailed(e.getMessage());

            }

            @Override
            public void onNext(CastPhoto castPhoto) {
                photoOnLoadCompleteListener.onLoadSussess(castPhoto);
            }
        });
        HttpMethods.toSubscribe(castPhoto, mCastPhoto);
    }


    @Override
    public void onDestroy() {
        if(mCastPhoto != null && mCastPhoto.isUnsubscribed()) {
            mCastPhoto.unsubscribe();
        }
    }
}
