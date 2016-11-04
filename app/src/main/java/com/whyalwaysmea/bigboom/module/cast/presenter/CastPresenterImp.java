package com.whyalwaysmea.bigboom.module.cast.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.module.cast.model.CastDetailModelImp;
import com.whyalwaysmea.bigboom.module.cast.model.ICastDetailModel;
import com.whyalwaysmea.bigboom.module.cast.view.ICastDetailView;

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
    public void getCastDetail(String id) {
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
    public void getCastWorks(String id, int start) {
        mCastDetailModel.loadCastWorks(id, start, new OnLoadCompleteListener<CastWork>() {
            @Override
            public void onLoadSussess(CastWork castWork) {
                mView.hideLoading();
                mView.showDetail(castWork);
            }

            @Override
            public void onLoadFailed(String error) {
                mView.hideLoading();
                mView.showToast(error);
            }
        });
    }


}
