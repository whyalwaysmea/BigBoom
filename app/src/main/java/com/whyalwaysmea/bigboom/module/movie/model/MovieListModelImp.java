package com.whyalwaysmea.bigboom.module.movie.model;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Movie;
import com.whyalwaysmea.bigboom.http.ApiManager;
import com.whyalwaysmea.bigboom.http.HttpMethods;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListModelImp implements IMovieListModel {

    private Subscription mSubscribe;

    @Override
    public void load(OnLoadCompleteListener<Movie> listener) {
        ApiManager apiManager = HttpMethods.createService(Constants.URL.HOT_MOVIE, ApiManager.class);
        mSubscribe = apiManager.getMovie(0, 50)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Movie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (null != listener) {
                            listener.onLoadFailed(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(Movie movie) {
                        if (null != listener) {
                            listener.onLoadSussess(movie);
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        if(null != mSubscribe && mSubscribe.isUnsubscribed()) {
            mSubscribe.unsubscribe();
        }
    }

}
