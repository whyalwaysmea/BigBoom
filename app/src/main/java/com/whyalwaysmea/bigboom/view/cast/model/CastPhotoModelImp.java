package com.whyalwaysmea.bigboom.view.cast.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;
import com.whyalwaysmea.bigboom.http.exception.ResponeThrowable;
import com.whyalwaysmea.bigboom.rx.RxSubscriber;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastPhotoModelImp implements ICastPhotoModel {

    private Subscription mCastPhoto;

    @Override
    public void loadCastPhoto(String id, int start, OnLoadCompleteListener<CastPhoto> photoOnLoadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService();
        mCastPhoto = apiManager.getCastPhoto(id, start, Constants.ID.APIKEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscriber<CastPhoto>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        photoOnLoadCompleteListener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(CastPhoto castPhoto) {
                        photoOnLoadCompleteListener.onLoadSussess(castPhoto);
                    }
                });
    }


    @Override
    public void onDestroy() {
        if (mCastPhoto != null && mCastPhoto.isUnsubscribed()) {
            mCastPhoto.unsubscribe();
        }
    }
}
