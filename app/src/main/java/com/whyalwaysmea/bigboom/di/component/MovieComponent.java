package com.whyalwaysmea.bigboom.di.component;

import com.whyalwaysmea.bigboom.di.module.MovieModule;
import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.CommentFragment;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MovieDetailActivity;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MoviePhotoActivity;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MoviePhotoListActivity;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.ReviewFragment;

import dagger.Component;

/**
 * Created by Long
 * on 2016/12/19.
 */
@ActivityScope
@Component(modules = MovieModule.class)
public interface MovieComponent {

    void inject(MovieDetailActivity movieDetailActivity);
    void inject(MoviePhotoActivity moviePhotoActivity);
    void inject(MoviePhotoListActivity moviePhotoListActivity);

    void inject(CommentFragment commentFragment);
    void inject(ReviewFragment reviewFragment);
}
