package com.whyalwaysmea.bigboom.view.cast.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;

import rx.Observable;

/**
 * Created by Long
 * on 2016/10/31.
 */

public interface ICastDetailModel extends BaseModel{
    Observable<CastDetail> loadCastDetails(String id);


    Observable<CastWork> loadCastWorks(String id, int start);
}
