package com.whyalwaysmea.bigboom.http.exception;

/**
 * Created by Long
 * on 2016/12/15.
 */

public class ResponeThrowable extends Exception {
    public int code;
    public String message;

    public ResponeThrowable(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
