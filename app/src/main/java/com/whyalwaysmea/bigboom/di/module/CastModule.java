package com.whyalwaysmea.bigboom.di.module;

import android.app.Activity;

import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.view.cast.view.ICastDetailView;
import com.whyalwaysmea.bigboom.view.cast.view.ICastPhotoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Long
 * on 2016/12/13.
 */
@Module
public class CastModule {
    private Activity mActivity;
    private ICastPhotoView mICastPhotoView;
    private ICastDetailView mCastDetailView;

    public CastModule(ICastPhotoView view) {
        this.mICastPhotoView = view;
    }
    public CastModule(ICastDetailView view) {
        this.mCastDetailView = view;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    public ICastPhotoView provideCastPhotoView() {return this.mICastPhotoView;}

    @Provides
    @ActivityScope
    public ICastDetailView provideCastDetailView() {return this.mCastDetailView;}
}
