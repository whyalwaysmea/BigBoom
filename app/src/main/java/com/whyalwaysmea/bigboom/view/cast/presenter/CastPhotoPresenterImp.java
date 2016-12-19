package com.whyalwaysmea.bigboom.view.cast.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.view.cast.model.CastPhotoModelImp;
import com.whyalwaysmea.bigboom.view.cast.model.ICastPhotoModel;
import com.whyalwaysmea.bigboom.view.cast.view.ICastPhotoView;

import javax.inject.Inject;

/**
 * Created by Long
 * on 2016/10/31.
 */
@ActivityScope
public class CastPhotoPresenterImp extends BasePresenter<ICastPhotoView> implements ICastPhotoPresenter, OnLoadCompleteListener<CastPhoto> {

    private ICastPhotoModel mPhotoModel;

    @Inject
    public CastPhotoPresenterImp(ICastPhotoView iCastDetailView) {
        super(iCastDetailView);
        mPhotoModel = new CastPhotoModelImp();
    }

    public CastPhotoPresenterImp() {
        super();
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
        mView.showLoading();
        mPhotoModel.loadCastPhoto(id, start, this);
    }

}
