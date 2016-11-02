package com.whyalwaysmea.bigboom.base;

import android.widget.Toast;

/**
 * Created by Long
 * on 2016/9/2.
 */
public abstract class MvpActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity implements BaseView{

    protected P mPresenter;


    protected abstract P createPresenter(BaseView view);

    @Override
    protected void init() {
        mPresenter = createPresenter(this);
        super.init();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null) {
            mPresenter.onDestroy();
        }
    }
}
