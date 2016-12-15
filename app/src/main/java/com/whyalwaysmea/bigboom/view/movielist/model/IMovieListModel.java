package com.whyalwaysmea.bigboom.view.movielist.model;

import android.support.annotation.Nullable;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;

/**
 * Created by Long
 * on 2016/9/5.
 */
public interface IMovieListModel extends BaseModel{

    void loadTop250(int start,int count, OnLoadCompleteListener<MovieListResponse> listener);

    void loadInTheaters(@Nullable String city, OnLoadCompleteListener<MovieListResponse> listener);

    void loadComingSoon(int start, int count, OnLoadCompleteListener<MovieListResponse> listener);

    void getSearchMovieList(int start, String keyWords, OnLoadCompleteListener<MovieListResponse> listener);

    void loadWeeklyMovies(OnLoadCompleteListener<WeeklyMovieInfo> listener);

    void loadNewMovies(OnLoadCompleteListener<MovieListResponse> listener);
}
