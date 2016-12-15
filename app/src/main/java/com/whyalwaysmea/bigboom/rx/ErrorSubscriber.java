package com.whyalwaysmea.bigboom.rx;

import com.whyalwaysmea.bigboom.http.exception.ResponeThrowable;

import rx.Subscriber;

/**
 * Created by Long
 * on 2016/12/15.
 */

public abstract class ErrorSubscriber<T> extends Subscriber<T>{
    @Override
    public void onError(Throwable e) {
        if(e instanceof ResponeThrowable) {
            onError((ResponeThrowable)e);
        } else {
            onError(new ResponeThrowable(e, 9999));
        }
    }

    protected abstract void onError(ResponeThrowable responeThrowable);
}
