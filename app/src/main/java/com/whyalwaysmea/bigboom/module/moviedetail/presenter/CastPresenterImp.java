package com.whyalwaysmea.bigboom.module.moviedetail.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.module.moviedetail.model.CastDetailModelImp;
import com.whyalwaysmea.bigboom.module.moviedetail.model.ICastDetailModel;
import com.whyalwaysmea.bigboom.module.moviedetail.view.ICastDetailView;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastPresenterImp extends BasePresenter<ICastDetailView> implements ICastPresenter  {

    private ICastDetailModel mCastDetailModel;

    public CastPresenterImp(ICastDetailView iCastDetailView) {
        super(iCastDetailView);
        mCastDetailModel = new CastDetailModelImp();
    }

    @Override
    public void getCastDetail(String id, OnLoadCompleteListener<CastDetail> castDetailOnLoadCompleteListener) {
        mCastDetailModel.loadCastDetails(id, new OnLoadCompleteListener<CastDetail>() {
            @Override
            public void onLoadSussess(CastDetail castDetail) {
                mView.hideLoading();
                mView.showDetail(castDetail);
            }

            @Override
            public void onLoadFailed(String error) {
                mView.hideLoading();
                mView.showToast(error);
            }
        });
    }


    @Override
    public void getCastWorks(String id, int start, OnLoadCompleteListener<CastWork> workOnLoadCompleteListener) {
        mCastDetailModel.loadCastWorks(id, start, new OnLoadCompleteListener<CastWork>() {
            @Override
            public void onLoadSussess(CastWork castWork) {
                mView.hideLoading();
                mView.showWorks(castWork);
            }

            @Override
            public void onLoadFailed(String error) {
                mView.hideLoading();
                mView.showToast(error);
            }
        });
    }


}
