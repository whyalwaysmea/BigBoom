package com.whyalwaysmea.bigboom.base;

/**
 * Created by Long
 * on 2016/9/2.
 */
public class BasePresenter<V> {

    protected V mView;

    public BasePresenter(V v) {
        mView = v;
    }

    public BasePresenter() {

    }


    public void onDestroy() {
        mView = null;
    }

}
