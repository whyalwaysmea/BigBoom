package com.whyalwaysmea.bigboom.http;

import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.bean.Comment;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.MoviePhoto;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
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

    @GET("search")
    Observable<MovieListResponse> getSearchMovieList(@Query("start") int start, @Query("q") String keyWords, @Query("apikey") String apikey);

    @GET("subject/{id}")
    Observable<MovieDetail> getSubject(@Path("id") String id, @Query("apikey") String apikey);

    @GET("subject/{id}/reviews")
    Observable<Review> getReview(@Path("id") String id, @Query("apikey") String apikey);

    @GET("subject/{id}/comments")
    Observable<Comment> getComment(@Path("id") String id, @Query("apikey") String apikey);

    @GET("subject/{id}/photos")
    Observable<MoviePhoto> getMoviePhoto(@Path("id") String id, @Query("start") int start, @Query("apikey") String apikey);

    @GET("celebrity/{id}")
    Observable<CastDetail> getCastDetail(@Path("id") String id,  @Query("apikey") String apikey);

    @GET("celebrity/{id}/photos")
    Observable<CastPhoto> getCastPhoto(@Path("id") String id, @Query("start") int start, @Query("apikey") String apikey);

    @GET("celebrity/{id}/works")
    Observable<CastWork> getCastWorks(@Path("id") String id, @Query("start") int start, @Query("apikey") String apikey);

}
