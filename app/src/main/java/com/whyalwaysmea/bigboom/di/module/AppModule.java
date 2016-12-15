package com.whyalwaysmea.bigboom.di.module;


import com.whyalwaysmea.bigboom.App;
import com.whyalwaysmea.bigboom.di.scope.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

}
