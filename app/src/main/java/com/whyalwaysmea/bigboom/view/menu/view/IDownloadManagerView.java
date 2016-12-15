package com.whyalwaysmea.bigboom.view.menu.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.DownloadPhoto;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/30.
 */

public interface IDownloadManagerView extends BaseView{

    void showDownloadPhotos(List<DownloadPhoto> bitmaps);

    void delDownloadPhotos();
}
