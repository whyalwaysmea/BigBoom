package com.whyalwaysmea.bigboom.module.menu.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.module.menu.view.IDownloadManagerView;
import com.whyalwaysmea.bigboom.utils.DownLoadUtils;
import com.whyalwaysmea.bigboom.utils.PermissionUtil;

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
                    mView.showToast("No Photo");
                    mView.hideLoading();
                    return ;
                }
                Observable.from(pictures)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new Func1<String, Bitmap>() {
                            @Override
                            public Bitmap call(String s) {
                                return  BitmapFactory.decodeFile(s);
                            }
                        })
                        .toList()
                        .subscribe(new Subscriber<List<Bitmap>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(List<Bitmap> bitmaps) {
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
}
