package com.whyalwaysmea.bigboom.module.moviedetail.presenter;

import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastPhoto;

/**
 * Created by Long
 * on 2016/10/31.
 */

public interface ICastPhotoPresenter {

    void getCastPhoto(String id, int start, OnLoadCompleteListener<CastPhoto> workOnLoadCompleteListener);
}
