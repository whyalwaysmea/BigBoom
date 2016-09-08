package com.whyalwaysmea.bigboom.module.movie.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Movie;

/**
 * Created by Long
 * on 2016/9/5.
 */
public interface IMovieListModel extends BaseModel{

    void load(int start,int count, OnLoadCompleteListener<Movie> listener);
}
