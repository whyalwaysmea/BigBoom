package com.whyalwasymea.bigboom.imageloader;

import android.widget.ImageView;

/**
 * Created by Long
 * on 2016/9/1.
 */
public interface ImageLoaderInterface {
    void display(ImageView imageView, String url);

    void display(ImageView imageView, String url, int loadingImg, int errorImg);

    void displayCircleImg(ImageView imageView, int resId);

    void displayCircleImg(ImageView imageView, String url);
}
