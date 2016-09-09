package com.whyalwaysmea.bigboom.module.movie.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;

/**
 * Created by Long
 * on 2016/9/5.
 */
public interface IMovieListModel extends BaseModel{

    void loadTop250(int start,int count, OnLoadCompleteListener<MovieListResponse> listener);

    void loadInTheaters(String city, OnLoadCompleteListener<MovieListResponse> listener);
}
