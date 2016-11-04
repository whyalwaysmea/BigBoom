package com.whyalwaysmea.bigboom.module.cast.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastDetailModelImp implements ICastDetailModel {


    private Subscription mCastDetail;
    private Subscription mCastWorks;

    @Override
    public void loadCastDetails(String id, OnLoadCompleteListener<CastDetail> onLoadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService();
        mCastDetail = apiManager.getCastDetail(id, Constants.ID.APIKEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CastDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onLoadCompleteListener.onLoadFailed(e.toString());
                    }

                    @Override
                    public void onNext(CastDetail castDetail) {
                        onLoadCompleteListener.onLoadSussess(castDetail);
                    }
                });
    }


    @Override
    public void loadCastWorks(String id, int start, OnLoadCompleteListener<CastWork> workOnLoadCompleteListener) {
        ApiManager apiManager = HttpMethods.createService();
        mCastWorks = apiManager.getCastWorks(id, start, Constants.ID.APIKEY)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CastWork>() {
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
        if (mCastDetail != null && mCastDetail.isUnsubscribed()) {
            mCastDetail.unsubscribe();
        }
        if (mCastWorks != null && mCastWorks.isUnsubscribed()) {
            mCastWorks.unsubscribe();
        }
    }
}
