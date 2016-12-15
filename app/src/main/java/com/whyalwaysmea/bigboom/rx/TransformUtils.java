package com.whyalwaysmea.bigboom.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/12/8.
 * 统一线程处理
 */
public class TransformUtils {
    public static <T> Observable.Transformer<T, T> defaultSchedulers() {
        return new Observable.Transformer<T, T>() {

            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .unsubscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io())
                        .compose(ErrorTransformer.<T>getInstance())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
