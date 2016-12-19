package com.whyalwaysmea.bigboom.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.di.scope.FragmentScope;
import com.whyalwaysmea.bigboom.view.movielist.view.IMovieListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Long
 * on 2016/12/13.
 */

@Module
public class MovieListModule {

    private Fragment fragment;
    private IMovieListView mMovieListView;

    public MovieListModule(IMovieListView movieListView) {
        this.mMovieListView = movieListView;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }

    @Provides
    @ActivityScope
    public IMovieListView provideMovieListView() {return this.mMovieListView;}
}
