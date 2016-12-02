package com.whyalwaysmea.bigboom.bean;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Long
 * on 2016/12/2.
 */

public class DownloadPhoto implements Serializable {

    public String url;

    public Bitmap bitmap;

    public boolean isCheck;

    public DownloadPhoto(String url, Bitmap bitmap, boolean isCheck) {
        this.url = url;
        this.bitmap = bitmap;
        this.isCheck = isCheck;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
