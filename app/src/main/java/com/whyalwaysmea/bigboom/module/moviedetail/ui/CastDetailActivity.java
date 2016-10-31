package com.whyalwaysmea.bigboom.module.moviedetail.ui;

import android.os.Bundle;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.module.moviedetail.presenter.CastPresenterImp;
import com.whyalwaysmea.bigboom.module.moviedetail.view.ICastDetailView;

public class CastDetailActivity extends MvpActivity<ICastDetailView, CastPresenterImp> implements ICastDetailView {

    @Override
    protected CastPresenterImp createPresenter(BaseView view) {
        return new CastPresenterImp(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_detail);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


    @Override
    public void showDetail(CastDetail castDetail) {

    }

    @Override
    public void showWorks(CastWork castWork) {

    }
}
