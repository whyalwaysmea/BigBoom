package com.whyalwaysmea.bigboom.rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Long
 * on 2016/11/8.
 */

public class RxBus {
    private static volatile RxBus mInstance;
    private final Subject<Object, Object> bus;
    private RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }
    //单例RxBus
    public static RxBus getInstance() {
        RxBus rxBus = mInstance;
        if (mInstance == null) {
            synchronized (RxBus.class) {
                rxBus = mInstance;
                if (mInstance == null) {
                    rxBus = new RxBus();
                    mInstance = rxBus;
                }
            }
        }
        return rxBus;
    }
    // 发送一个新事件
    public void send(Object o) {
        bus.onNext(o);
    }

    // 返回特定类型的被观察者
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }
}
