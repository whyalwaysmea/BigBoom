package com.whyalwaysmea.bigboom.view.menu.presenter;

import android.app.Activity;

import com.whyalwaysmea.bigboom.bean.DownloadPhoto;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/30.
 */

public interface IDownloadManagerPresenter {

    void getDownloadPhotos(Activity activity);

    void delDownloadPhotos(List<Integer> delPosition, List<DownloadPhoto> downloadPhotos);

}
