package com.whyalwaysmea.bigboom.module.moviedetail.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.module.moviedetail.model.CastPhotoModelImp;
import com.whyalwaysmea.bigboom.module.moviedetail.model.ICastPhotoModel;
import com.whyalwaysmea.bigboom.module.moviedetail.view.ICastPhotoView;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class CastPhotoPresenterImp extends BasePresenter<ICastPhotoView> implements ICastPhotoModel, OnLoadCompleteListener<CastPhoto> {

    private ICastPhotoModel mPhotoModel;

    public CastPhotoPresenterImp(ICastPhotoView iCastDetailView) {
        super(iCastDetailView);
        mPhotoModel = new CastPhotoModelImp();
    }


    @Override
    public void loadCastPhoto(String id, int start, OnLoadCompleteListener<CastPhoto> photoOnLoadCompleteListener) {
        mPhotoModel.loadCastPhoto(id, start, this);
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
}
