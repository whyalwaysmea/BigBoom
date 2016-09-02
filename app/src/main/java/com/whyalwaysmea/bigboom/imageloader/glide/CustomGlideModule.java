package com.whyalwaysmea.bigboom.imageloader.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.module.GlideModule;
import com.whyalwaysmea.bigboom.App;

import java.io.File;

/**
 * Created by Long
 * on 2016/9/1.
 * Glide modules是一个全局改变Glide行为的抽象的方式。
 */
public class CustomGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                // Careful: the external cache directory doesn't enforce permissions
                File cacheFile = new File(App.getApplication().getCacheDir(), "images");
                cacheFile.mkdirs();
                //104857600 == 100M
                return DiskLruCacheWrapper.get(cacheFile, 104857600);
            }
        });
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
