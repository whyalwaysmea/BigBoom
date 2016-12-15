package com.whyalwaysmea.bigboom.di.module;

import android.app.Activity;

import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.view.cast.view.ICastPhotoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Long
 * on 2016/12/13.
 */
@Module
public class ActivityModule {
    private Activity mActivity;
    private ICastPhotoView mView;

    public ActivityModule(ICastPhotoView view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    public ICastPhotoView provideView() {return this.mView;}
}
