package com.whyalwaysmea.bigboom.module.moviedetail.presenter;

import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;

/**
 * Created by Long
 * on 2016/10/31.
 */

public interface ICastPresenter {
    void getCastDetail(String id, OnLoadCompleteListener<CastDetail> castDetailOnLoadCompleteListener);

    void getCastWorks(String id, int start, OnLoadCompleteListener<CastWork> workOnLoadCompleteListener);
}
