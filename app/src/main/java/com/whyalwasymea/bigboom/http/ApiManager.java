package com.whyalwasymea.bigboom.http;

import com.whyalwasymea.bigboom.bean.Movie;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Long
 * on 2016/9/1.
 */
public interface ApiManager {
    @GET("top250")
    Observable<Movie> getMovie();
}
