package com.whyalwaysmea.bigboom.bean;

import java.io.Serializable;

/**
 * Created by Long
 * on 2016/11/15.
 */

public class MovieVideo implements Serializable {

    public String url;

    public String img;

    public String title;


    public MovieVideo(String url, String img) {
        this.url = url;
        this.img = img;
    }

    public MovieVideo(String url, String img, String title) {
        this.url = url;
        this.img = img;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
