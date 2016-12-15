package com.whyalwaysmea.bigboom.rx;

import com.whyalwaysmea.bigboom.http.exception.ExceptionHandle;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Long
 * on 2016/12/15.
 */

public class ErrorTransformer<T> implements Observable.Transformer<T, T>{
    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable.onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                throwable.printStackTrace();
                return Observable.error(ExceptionHandle.handleException(throwable));
            }
        });
    }

    public static <T> ErrorTransformer<T> create() {
        return new ErrorTransformer<>();
    }

    private static ErrorTransformer instance = null;

    private ErrorTransformer(){
    }
    /**
     * 双重校验锁单例(线程安全)
     */
    public static <T>ErrorTransformer<T> getInstance() {
        if (instance == null) {
            synchronized (ErrorTransformer.class) {
                if (instance == null) {
                    instance = new ErrorTransformer();
                }
            }
        }
        return instance;
    }
}
