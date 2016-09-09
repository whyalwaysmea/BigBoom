package com.whyalwaysmea.bigboom.http;

import com.whyalwaysmea.bigboom.bean.MovieListResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Long
 * on 2016/9/1.
 */
public interface ApiManager {

    @GET("top250")
    Observable<MovieListResponse> getMovie(@Query("start") int start, @Query("count") int count);
}
