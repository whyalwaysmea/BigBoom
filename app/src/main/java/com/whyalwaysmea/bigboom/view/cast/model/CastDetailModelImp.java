package com.whyalwaysmea.bigboom.view.cast.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;
import com.whyalwaysmea.bigboom.rx.TransformUtils;

import rx.Observable;
import rx.Subscription;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastDetailModelImp implements ICastDetailModel {


    private Subscription mCastDetail;
    private Subscription mCastWorks;

    @Override
    public Observable<CastDetail> loadCastDetails(String id) {
        ApiManager apiManager = HttpMethods.createService();
//        mCastDetail =

        return apiManager.getCastDetail(id, Constants.ID.APIKEY)
                .compose(TransformUtils.<CastDetail>defaultSchedulers());
    }


    @Override
    public Observable<CastWork> loadCastWorks(String id, int start) {
        ApiManager apiManager = HttpMethods.createService();
        return apiManager.getCastWorks(id, start, Constants.ID.APIKEY)
                .compose(TransformUtils.<CastWork>defaultSchedulers());


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
