package com.whyalwaysmea.bigboom.base;

/**
 * Created by Long
 * on 2016/9/5.
 */
public interface OnLoadCompleteListener<T> {

    void onLoadSussess(T t);

    void onLoadFailed(String error);

}
