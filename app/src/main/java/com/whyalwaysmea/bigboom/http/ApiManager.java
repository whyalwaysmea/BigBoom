package com.whyalwaysmea.bigboom.http;

import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Long
 * on 2016/9/1.
 */
public interface ApiManager {

    @GET("top250")
    Observable<MovieListResponse> getTop250Movie(@Query("start") int start, @Query("count") int count);

    @GET("in_theaters")
    Observable<MovieListResponse> getInTheatersMovie(@Query("city") String city);

    @GET("coming_soon")
    Observable<MovieListResponse> getComingSoonMovie(@Query("start") int start, @Query("count") int count);

    @GET("weekly")
    Observable<WeeklyMovieInfo> getWeeklyMovie(@Query("apikey") String apikey);

    @GET("new_movies")
    Observable<MovieListResponse> getNewMovies(@Query("apikey") String apikey);
}
