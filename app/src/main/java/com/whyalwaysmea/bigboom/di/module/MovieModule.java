package com.whyalwaysmea.bigboom.di.module;

import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieCommentView;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieDetailView;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMoviePhotoListView;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieReviewView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Long
 * on 2016/12/19.
 */
@Module
public class MovieModule {

    private IMovieCommentView mCommentView;
    private IMovieDetailView mMovieDetailView;
    private IMoviePhotoListView mPhotoListView;
    private IMovieReviewView mMovieReviewView;

    public MovieModule(IMovieCommentView view) {this.mCommentView = view;}
    public MovieModule(IMovieDetailView view) {this.mMovieDetailView = view;}
    public MovieModule(IMoviePhotoListView view) {this.mPhotoListView = view;}
    public MovieModule(IMovieReviewView view) {this.mMovieReviewView = view;}

    @Provides
    @ActivityScope
    public IMovieCommentView provideMovieCommentView() {return this.mCommentView;}

    @Provides
    @ActivityScope
    public IMovieDetailView provideMovieDetailView() {return this.mMovieDetailView;}

    @Provides
    @ActivityScope
    public IMoviePhotoListView provideMoviePhotoListView() {return this.mPhotoListView;}

    @Provides
    @ActivityScope
    public IMovieReviewView provideMovieReviewView() {return this.mMovieReviewView;}
}
