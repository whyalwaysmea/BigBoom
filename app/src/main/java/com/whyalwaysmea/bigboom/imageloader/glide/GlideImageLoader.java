package com.whyalwaysmea.bigboom.imageloader.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.imageloader.ImageLoaderInterface;

/**
 * Created by Long
 * on 2016/9/1.
 */
public class GlideImageLoader implements ImageLoaderInterface {


    @Override
    public void display(ImageView imageView, String url) {
        display(imageView,url, R.drawable.ic_photo_size_select_actual_white_24dp, R.drawable.ic_photo_size_select_actual_white_24dp);
    }

    @Override
    public void display(ImageView imageView, int resId) {
        display(imageView, resId, R.drawable.ic_photo_size_select_actual_white_24dp, R.drawable.ic_photo_size_select_actual_white_24dp);
    }

    @Override
    public void display(ImageView imageView, String url, int loadingImg, int errorImg) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        DrawableTypeRequest request = Glide.with(imageView.getContext()).load(url);
        // 设置加载中以及加载失败图片
        if(0 != loadingImg) {
            request.placeholder(loadingImg);
        }
        if(0 != errorImg) {
            request.error(errorImg);
        }
        request
                //设置缓存策略，默认不缓存原始图，只缓存结果图
                //现改为缓存所有图，否则断网时，类似于瀑布流效果（imageView长款不定时，glide本该去重新加载原始图，然后
                // 根据ImageView的目标尺寸进行相应调整）将无法正常显示；
                //若缓存了原始图，则glide可以从缓存加载原始图，并且进行相应尺寸调整了
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //用原图的1/10作为缩略图，如果缩略图先被加载出来则先显示缩略图
                .thumbnail(0.1f)
                // 设置加载动画,默认
                .crossFade()
                //解决加载出来的瞬间闪一下的问题
                .dontAnimate()
                .into(imageView);
    }

    @Override
    public void display(ImageView imageView, int resId, int loadingImg, int errorImg) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        DrawableTypeRequest request = Glide.with(imageView.getContext()).load(resId);
        // 设置加载中以及加载失败图片
        if(0 != loadingImg) {
            request.placeholder(loadingImg);
        }
        if(0 != errorImg) {
            request.error(errorImg);
        }
        request
                //设置缓存策略，默认不缓存原始图，只缓存结果图
                //现改为缓存所有图，否则断网时，类似于瀑布流效果（imageView长款不定时，glide本该去重新加载原始图，然后
                // 根据ImageView的目标尺寸进行相应调整）将无法正常显示；
                //若缓存了原始图，则glide可以从缓存加载原始图，并且进行相应尺寸调整了
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //用原图的1/10作为缩略图，如果缩略图先被加载出来则先显示缩略图
                .thumbnail(0.1f)
                // 设置加载动画,默认
                .crossFade()
                //解决加载出来的瞬间闪一下的问题
                .dontAnimate()
                .into(imageView);
    }

    // 设置动态转换， 圆形
    @Override
    public void displayCircleImg(ImageView imageView, int resId) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(imageView.getContext())
                .load(resId)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    // 设置动态转换， 圆形
    @Override
    public void displayCircleImg(Context context, String url, GlideDrawableImageViewTarget glideDrawableImageViewTarget) {
        if (glideDrawableImageViewTarget == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context)
                .load(url)
                .transform(new GlideCircleTransform(context))
                .into(glideDrawableImageViewTarget);
    }


    // 设置动态转换， 圆形
    @Override
    public void displayCircleImg(ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(imageView.getContext())
                .load(url)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayAsBitmap(Context context, String url, com.bumptech.glide.request.target.Target<Bitmap> bitmapTarget) {
        if (context == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context)
                .load(url)
                .asBitmap()
                .into(bitmapTarget);
    }



}
