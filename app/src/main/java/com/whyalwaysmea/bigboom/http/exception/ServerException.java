package com.whyalwaysmea.bigboom.http.exception;

/**
 * Created by Long
 * on 2016/12/15.
 */

public class ServerException extends RuntimeException {
    public int code;
    public String message;

    public ServerException(String message, int code) {
        this.message=message;
        this.code = code;
    }
}