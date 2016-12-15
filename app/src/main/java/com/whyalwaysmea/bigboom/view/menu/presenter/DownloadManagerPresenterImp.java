package com.whyalwaysmea.bigboom.view.menu.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.bean.DownloadPhoto;
import com.whyalwaysmea.bigboom.view.menu.view.IDownloadManagerView;
import com.whyalwaysmea.bigboom.utils.DownLoadUtils;
import com.whyalwaysmea.bigboom.utils.PermissionUtil;

import java.io.File;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Long
 * on 2016/11/30.
 */

public class DownloadManagerPresenterImp extends BasePresenter<IDownloadManagerView> implements IDownloadManagerPresenter{

    public DownloadManagerPresenterImp(IDownloadManagerView iDownloadManagerView) {
        super(iDownloadManagerView);
    }

    @Override
    public void getDownloadPhotos(Activity activity) {
        mView.showLoading();
        PermissionUtil.readExternalStorage(new PermissionUtil.RequestPermission() {
            @Override
            public void onRequestPermissionSuccess() {
                List<String> pictures = DownLoadUtils.getPictures();
                if(pictures == null || pictures.isEmpty()) {
                    mView.hideLoading();
                    return ;
                }
                Observable.from(pictures)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new Func1<String, DownloadPhoto>() {
                            @Override
                            public DownloadPhoto call(String s) {
                                Bitmap bitmap = BitmapFactory.decodeFile(s);
                                return  new DownloadPhoto(s, bitmap, false);
                            }
                        })
                        .toList()
                        .subscribe(new Subscriber<List<DownloadPhoto>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(List<DownloadPhoto> bitmaps) {
                                mView.showDownloadPhotos(bitmaps);
                                mView.hideLoading();
                            }
                        });
            }

            @Override
            public void onRequestPermissionFailed() {
                mView.showToast("request READ_EXTERNAL_STORAGE failed");
                mView.hideLoading();
            }
        }, new RxPermissions(activity));



    }

    @Override
    public void delDownloadPhotos(List<Integer> delPosition, List<DownloadPhoto> downloadPhotos) {
        mView.showLoading();
        Observable.from(delPosition)
                .map(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        DownloadPhoto downloadPhoto = downloadPhotos.get(integer);
                        File file = new File(downloadPhoto.getUrl());
                        if(file.exists()) {
                            boolean delete = file.delete();
                            return delete;
                        }
                        return false;
                    }
                })
                .toList()
                .subscribe(new Subscriber<List<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Boolean> booleen) {
                        mView.delDownloadPhotos();
                        mView.hideLoading();
                    }
                });
    }
}
