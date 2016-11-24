package com.whyalwaysmea.bigboom.bean.db;

/**
 * Created by Long
 * on 2016/11/24.
 */

public class HistoryBean {

    public Long id;
    public String historyId;
    public int type;
    public String imgUrl;
    public int movieSize;
    public int castSize;

    public HistoryBean(Long id, String historyId, int type, String imgUrl) {
        this.id = id;
        this.historyId = historyId;
        this.type = type;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getMovieSize() {
        return movieSize;
    }

    public void setMovieSize(int movieSize) {
        this.movieSize = movieSize;
    }

    public int getCastSize() {
        return castSize;
    }

    public void setCastSize(int castSize) {
        this.castSize = castSize;
    }
}
