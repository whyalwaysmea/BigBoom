package com.whyalwaysmea.bigboom.imageloader;

import android.widget.ImageView;

import com.whyalwaysmea.bigboom.imageloader.glide.GlideImageLoader;

/**
 * Created by Long
 * on 2016/9/1.
 */
public class ImageUtils {
    private static final ImageLoaderInterface DEFAULT_LOADER = new GlideImageLoader();
    private ImageLoaderInterface mLoaderInterface;

    private ImageUtils() {

        //默认用Glide加载，若要换其他库，自己写一个类实现imageloader然后替换掉GlideImageLoader即可。
        //之所以没有把imageloader放在方法的参数里，因为考虑到外部调用时，对外应该是透明的。
        //当然也可以在application里面初始化的时候设置。
        mLoaderInterface = DEFAULT_LOADER;
    }

    public static ImageUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(ImageLoaderInterface imageLoaderInterface) {
        mLoaderInterface = imageLoaderInterface;
    }

    public void display(ImageView imageView, String url) {

        mLoaderInterface.display(imageView, url);
    }

    public void display(ImageView imageView, String url, int loadingImg, int errorImg) {

        mLoaderInterface.display(imageView, url, loadingImg, errorImg);
    }

    public void display(ImageView imageView, int resId) {
        mLoaderInterface.display(imageView, resId);

    }

    public void displayCircleImg(ImageView imageView, int resId) {

        mLoaderInterface.displayCircleImg(imageView, resId);
    }

    public void displayCircleImg(ImageView imageView, String url) {

        mLoaderInterface.displayCircleImg(imageView, url);
    }

    private static final class SingletonHolder {
        private static final ImageUtils INSTANCE = new ImageUtils();
    }

}
