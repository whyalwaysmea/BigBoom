package com.whyalwaysmea.bigboom.module.menu.view;

import android.graphics.Bitmap;

import com.whyalwaysmea.bigboom.base.BaseView;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/30.
 */

public interface IDownloadManagerView extends BaseView{

    void showDownloadPhotos(List<Bitmap> bitmaps);

}
