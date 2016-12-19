package com.whyalwaysmea.bigboom.view.cast.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.http.exception.ResponeThrowable;
import com.whyalwaysmea.bigboom.rx.RxSubscriber;
import com.whyalwaysmea.bigboom.view.cast.model.CastDetailModelImp;
import com.whyalwaysmea.bigboom.view.cast.model.ICastDetailModel;
import com.whyalwaysmea.bigboom.view.cast.view.ICastDetailView;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastPresenterImp extends BasePresenter<ICastDetailView> implements ICastPresenter  {

    private ICastDetailModel mCastDetailModel;

    @Inject
    public CastPresenterImp(ICastDetailView iCastDetailView) {
        super(iCastDetailView);
        mCastDetailModel = new CastDetailModelImp();
    }

    @Override
    public void getCastDetail(String id) {
        mCastDetailModel
                .loadCastDetails(id)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscriber<CastDetail>() {
                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        mView.hideLoading();
                        mView.showToast(responeThrowable.message);
                    }

                    @Override
                    public void onNext(CastDetail castDetail) {
                        mView.hideLoading();
                        mView.showDetail(castDetail);
                    }
                });
    }


    @Override
    public void getCastWorks(String id, int start) {
        mCastDetailModel.loadCastWorks(id, start)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscriber<CastWork>() {
                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        mView.hideLoading();
                        mView.showToast(responeThrowable.message);
                    }

                    @Override
                    public void onNext(CastWork castWork) {
                        mView.hideLoading();
                        mView.showDetail(castWork);
                    }
                });
    }
}
