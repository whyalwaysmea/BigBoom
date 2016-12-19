package com.whyalwaysmea.bigboom.di.component;

import com.whyalwaysmea.bigboom.di.module.MovieListModule;
import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.view.movielist.ui.ComingSoonFragment;
import com.whyalwaysmea.bigboom.view.movielist.ui.InTheatersMovieListFragment;
import com.whyalwaysmea.bigboom.view.movielist.ui.SearchMovieListActivity;
import com.whyalwaysmea.bigboom.view.movielist.ui.Top250MovieListFragment;

import dagger.Component;

/**
 * Created by Long
 * on 2016/12/19.
 */
@ActivityScope
@Component(modules = MovieListModule.class)
public interface MovieListComponent {

    void inject(ComingSoonFragment comingSoonFragment);
    void inject(InTheatersMovieListFragment inTheatersMovieListFragment);
    void inject(Top250MovieListFragment top250MovieListFragment);

    void inject(SearchMovieListActivity searchMovieListActivity);
}
