package com.whyalwaysmea.bigboom.bean.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Long
 * on 2016/11/23.
 */
@Entity
public class DBCast {

    @Id(autoincrement = true)
    private Long id;

    private String castId;
    private String imgUrl;
    @Generated(hash = 1473835938)
    public DBCast(Long id, String castId, String imgUrl) {
        this.id = id;
        this.castId = castId;
        this.imgUrl = imgUrl;
    }
    @Generated(hash = 441168922)
    public DBCast() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCastId() {
        return this.castId;
    }
    public void setCastId(String castId) {
        this.castId = castId;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
