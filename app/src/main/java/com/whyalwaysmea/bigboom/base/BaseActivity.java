package com.whyalwaysmea.bigboom.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Long
 * on 2016/9/2.
 */
public class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{




    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {

    }
}
