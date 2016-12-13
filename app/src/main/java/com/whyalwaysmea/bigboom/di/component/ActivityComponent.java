package com.whyalwaysmea.bigboom.di.component;

import android.app.Activity;

import com.whyalwaysmea.bigboom.di.ActivityScope;
import com.whyalwaysmea.bigboom.di.module.ActivityModule;
import com.whyalwaysmea.bigboom.module.cast.ui.PhotoListActivity;

import dagger.Component;

/**
 * Created by Long
 * on 2016/12/13.
 */
@ActivityScope
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(PhotoListActivity photoListActivity);
}
