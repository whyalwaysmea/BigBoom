package com.whyalwaysmea.bigboom.di.component;


import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.di.scope.ContextLife;
import com.whyalwaysmea.bigboom.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    App getContext();  // 提供App的Context

}
