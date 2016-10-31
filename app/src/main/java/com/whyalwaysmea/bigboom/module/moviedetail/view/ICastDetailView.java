package com.whyalwaysmea.bigboom.module.moviedetail.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;

/**
 * Created by Long
 * on 2016/10/31.
 */

public interface ICastDetailView extends BaseView {
    void showDetail(CastDetail castDetail);

    void showWorks(CastWork castWork);

}
