package com.whyalwaysmea.bigboom.module.moviedetail.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastDetailModelImp implements ICastDetailModel {


    private Subscription mCastDetail;
    private Subscription mCastPhoto;
    private Subscription mCastWorks;

    @Override
    public void loadCastDetails(String id, OnLoadCompleteListener<CastDetail> onLoadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService();
        Observable<CastDetail> castDetail = apiManager.getCastDetail(id, Constants.ID.APIKEY);
        mCastDetail = castDetail.subscribe(new Subscriber<CastDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoadCompleteListener.onLoadFailed(e.getMessage());
            }

            @Override
            public void onNext(CastDetail castDetail) {
                onLoadCompleteListener.onLoadSussess(castDetail);
            }
        });
        HttpMethods.toSubscribe(castDetail, mCastDetail);
    }

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
    public void loadCastWorks(String id, int start, OnLoadCompleteListener<CastWork> workOnLoadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService();
        Observable<CastWork> castWorks = apiManager.getCastWorks(id, start, Constants.ID.APIKEY);
        mCastWorks = castWorks.subscribe(new Subscriber<CastWork>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                workOnLoadCompleteListener.onLoadFailed(e.getMessage());

            }

            @Override
            public void onNext(CastWork castWork) {
                workOnLoadCompleteListener.onLoadSussess(castWork);
            }
        });
    }

    @Override
    public void onDestroy() {
        if(mCastDetail != null && mCastDetail.isUnsubscribed()) {
            mCastDetail.unsubscribe();
        }
        if(mCastPhoto != null && mCastPhoto.isUnsubscribed()) {
            mCastPhoto.unsubscribe();
        }
        if(mCastWorks != null && mCastWorks.isUnsubscribed()) {
            mCastWorks.unsubscribe();
        }
    }
}
