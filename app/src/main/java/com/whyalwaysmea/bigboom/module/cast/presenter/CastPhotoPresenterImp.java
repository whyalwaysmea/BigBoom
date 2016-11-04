package com.whyalwaysmea.bigboom.module.cast.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.module.cast.model.CastPhotoModelImp;
import com.whyalwaysmea.bigboom.module.cast.model.ICastPhotoModel;
import com.whyalwaysmea.bigboom.module.cast.view.ICastPhotoView;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastPhotoPresenterImp extends BasePresenter<ICastPhotoView> implements ICastPhotoPresenter, OnLoadCompleteListener<CastPhoto> {

    private ICastPhotoModel mPhotoModel;

    public CastPhotoPresenterImp(ICastPhotoView iCastDetailView) {
        super(iCastDetailView);
        mPhotoModel = new CastPhotoModelImp();
    }


    @Override
    public void onLoadSussess(CastPhoto castPhoto) {
        mView.hideLoading();
        mView.showPhotos(castPhoto);
    }

    @Override
    public void onLoadFailed(String error) {
        mView.hideLoading();
        mView.showToast(error);
    }

    @Override
    public void getCastPhoto(String id, int start) {
        mPhotoModel.loadCastPhoto(id, start, this);
    }
}
