package com.whyalwaysmea.bigboom.view.movielist.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;
import com.whyalwaysmea.bigboom.http.exception.ResponeThrowable;
import com.whyalwaysmea.bigboom.rx.RxSubscriber;
import com.whyalwaysmea.bigboom.rx.TransformUtils;

import rx.Subscription;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListModelImp implements IMovieListModel {

    private Subscription mSubscribe;
    private Subscription mSearchMovieList;

    @Override
    public void loadTop250(int start, int count, OnLoadCompleteListener<MovieListResponse> listener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscribe = apiManager.getTop250Movie(start, count)
                .compose(TransformUtils.<MovieListResponse>defaultSchedulers())
                .subscribe(new RxSubscriber<MovieListResponse>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        listener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(MovieListResponse response) {
                        if (null != listener && response.getCount() > 0) {
                            listener.onLoadSussess(response);
                        } else {
                            listener.onLoadFailed("无更多数据 ヾﾉ≧∀≦)o");
                        }
                    }
                });
    }

    @Override
    public void loadInTheaters(String city, OnLoadCompleteListener<MovieListResponse> listener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscribe = apiManager.getInTheatersMovie(city)
                .compose(TransformUtils.<MovieListResponse>defaultSchedulers())
                .subscribe(new RxSubscriber<MovieListResponse>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        listener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                        if (null != listener && movieListResponse.getCount() > 0) {
                            listener.onLoadSussess(movieListResponse);
                        } else {
                            listener.onLoadFailed("无更多数据 ヾﾉ≧∀≦)o");
                        }
                    }
                });
    }

    @Override
    public void loadComingSoon(int start, int count, OnLoadCompleteListener<MovieListResponse> listener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscribe = apiManager.getComingSoonMovie(start, count)
                .compose(TransformUtils.<MovieListResponse>defaultSchedulers())
                .subscribe(new RxSubscriber<MovieListResponse>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        listener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                        if (null != listener && movieListResponse.getCount() > 0) {
                            listener.onLoadSussess(movieListResponse);
                        } else {
                            listener.onLoadFailed("无更多数据 ヾﾉ≧∀≦)o");
                        }
                    }
                });
    }

    @Override
    public void getSearchMovieList(int start,String keyWords, OnLoadCompleteListener<MovieListResponse> listener) {
        ApiManager apiManager = HttpMethods.createService();
        mSearchMovieList = apiManager.getSearchMovieList(start, keyWords, Constants.ID.APIKEY)
                .compose(TransformUtils.<MovieListResponse>defaultSchedulers())
                .subscribe(new RxSubscriber<MovieListResponse>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        listener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                        if (null != listener && movieListResponse.getCount() > 0) {
                            listener.onLoadSussess(movieListResponse);
                        } else {
                            listener.onLoadFailed("无更多数据 ヾﾉ≧∀≦)o");
                        }
                    }
                });
    }

    @Override
    public void loadWeeklyMovies(OnLoadCompleteListener<WeeklyMovieInfo> listener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscribe = apiManager.getWeeklyMovie(Constants.ID.APIKEY)
                .compose(TransformUtils.<WeeklyMovieInfo>defaultSchedulers())
                .subscribe(new RxSubscriber<WeeklyMovieInfo>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        listener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(WeeklyMovieInfo weeklyMovieInfo) {
                        if (null != listener && weeklyMovieInfo.getSubjects().size() > 0) {
                            listener.onLoadSussess(weeklyMovieInfo);
                        } else {
                            listener.onLoadFailed("无更多数据 ヾﾉ≧∀≦)o");
                        }
                    }
                });
    }


    @Override
    public void loadNewMovies(OnLoadCompleteListener<MovieListResponse> listener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.MOVIE, ApiManager.class);
        mSubscribe = apiManager.getNewMovies(Constants.ID.APIKEY)
                .compose(TransformUtils.<MovieListResponse>defaultSchedulers())
                .subscribe(new RxSubscriber<MovieListResponse>() {

                    @Override
                    protected void onError(ResponeThrowable responeThrowable) {
                        listener.onLoadFailed(responeThrowable.message);
                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                        if (null != listener && movieListResponse.getSubjects().size() > 0) {
                            listener.onLoadSussess(movieListResponse);
                        } else {
                            listener.onLoadFailed("无更多数据 ヾﾉ≧∀≦)o");
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        if(null != mSubscribe && mSubscribe.isUnsubscribed()) {
            mSubscribe.unsubscribe();
        }
        if(null != mSearchMovieList && mSearchMovieList.isUnsubscribed()) {
            mSearchMovieList.unsubscribe();
        }


    }

}
