package com.whyalwasymea.bigboom;

import android.app.Application;
import android.content.Context;

import com.whyalwasymea.bigboom.imageloader.ImageUtils;
import com.whyalwasymea.bigboom.imageloader.glide.GlideImageLoader;

/**
 * @author: Long
 * @Date: 2016/9/1 14:25
 */
public class App extends Application{
    private static App application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        // 初始化Glide
        ImageUtils.getInstance().init(new GlideImageLoader());

    }

    public static Context getApplication() {
        return application;
    }
}
