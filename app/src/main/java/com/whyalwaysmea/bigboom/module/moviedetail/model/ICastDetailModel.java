package com.whyalwaysmea.bigboom.module.moviedetail.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;

/**
 * Created by Long
 * on 2016/10/31.
 */

public interface ICastDetailModel extends BaseModel{
    void loadCastDetails(String id, OnLoadCompleteListener<CastDetail> onLoadCompleteListener);


    void loadCastWorks(String id, int start, OnLoadCompleteListener<CastWork> workOnLoadCompleteListener);
}
