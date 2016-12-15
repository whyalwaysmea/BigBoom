package com.whyalwaysmea.bigboom.view.cast.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastPhoto;

/**
 * Created by Long
 * on 2016/10/31.
 */

public interface ICastPhotoModel extends BaseModel{

    void loadCastPhoto(String id, int start, OnLoadCompleteListener<CastPhoto> photoOnLoadCompleteListener);
}
