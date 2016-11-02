package com.whyalwaysmea.bigboom;

import android.app.Application;
import android.content.Context;

import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.imageloader.glide.GlideImageLoader;

/**
 * @author: Long
 * @Date: 2016/9/1 14:25
 */
public class App extends Application{
    private static App application;
    public static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        // 初始化Glide
        ImageUtils.getInstance().init(new GlideImageLoader());

        // 初始化log
        KLog.init(BuildConfig.DEBUG, "Boom");

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        sRefWatcher = LeakCanary.install(this);

    }

    public static Context getApplication() {
        return application;
    }
}
