package com.whyalwaysmea.bigboom.di.component;

import android.app.Activity;

import com.whyalwaysmea.bigboom.di.module.CastModule;
import com.whyalwaysmea.bigboom.di.scope.ActivityScope;
import com.whyalwaysmea.bigboom.view.cast.ui.AllWorksActivity;
import com.whyalwaysmea.bigboom.view.cast.ui.CastDetailActivity;
import com.whyalwaysmea.bigboom.view.cast.ui.PhotoActivity;
import com.whyalwaysmea.bigboom.view.cast.ui.PhotoListActivity;

import dagger.Component;

/**
 * Created by Long
 * on 2016/12/13.
 */
@ActivityScope
@Component(modules = CastModule.class)
public interface CastComponent {
    Activity getActivity();

    void inject(PhotoListActivity photoListActivity);
    void inject(PhotoActivity photoActivity);
    void inject(CastDetailActivity castDetailActivity);
    void inject(AllWorksActivity allWorksActivity);
}
