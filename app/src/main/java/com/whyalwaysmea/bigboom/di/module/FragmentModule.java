package com.whyalwaysmea.bigboom.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.whyalwaysmea.bigboom.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Long
 * on 2016/12/13.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
