package com.whyalwaysmea.bigboom.service;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.rx.RxBus;

import java.util.concurrent.ExecutionException;

/**
 * Created by Long
 * on 2016/11/8.
 */

public class ImageService extends IntentService {

    public ImageService() {
        super("ImageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        CastPhoto castPhoto = (CastPhoto) intent.getSerializableExtra(Constants.KEY.CAST_PHOTO);
        handleGirlItemData(castPhoto);
    }

    private void handleGirlItemData(CastPhoto datas) {
        if (datas==null || datas.getPhotos().size() == 0) {
            return ;
        }
        for (CastPhoto.PhotosBean data : datas.getPhotos()) {
            try {
                Bitmap bitmap = Glide.with(this)
                        .load(data.getImage())
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get();
                if (bitmap != null) {
                    data.setWidth(bitmap.getWidth());
                    data.setHeight(bitmap.getHeight());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        RxBus.getInstance().send(datas);
    }
}
