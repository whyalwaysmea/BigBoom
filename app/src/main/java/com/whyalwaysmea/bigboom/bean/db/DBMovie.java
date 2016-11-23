package com.whyalwaysmea.bigboom.bean.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Long
 * on 2016/11/23.
 */
@Entity
public class DBMovie {
    @Id(autoincrement = true)
    private Long id;

    private String movieId;
    private String imgUrl;
    @Generated(hash = 202850822)
    public DBMovie(Long id, String movieId, String imgUrl) {
        this.id = id;
        this.movieId = movieId;
        this.imgUrl = imgUrl;
    }
    @Generated(hash = 1728432208)
    public DBMovie() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMovieId() {
        return this.movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
