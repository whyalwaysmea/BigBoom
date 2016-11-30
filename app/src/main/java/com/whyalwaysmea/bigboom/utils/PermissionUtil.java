package com.whyalwaysmea.bigboom.utils;

import android.Manifest;

import com.socks.library.KLog;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Created by Long
 * on 2016/11/30.
 */

public class PermissionUtil {

    public interface RequestPermission {
        void onRequestPermissionSuccess();
        void onRequestPermissionFailed();
    }

    /**
     * 请求外部存储的权限
     */
    public static void externalStorage(final RequestPermission requestPermission, RxPermissions rxPermissions) {
        boolean isPermissionsGranted =
                rxPermissions
                        .isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (isPermissionsGranted) {//已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess();
        } else {//没有申请过，则申请
            rxPermissions
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            KLog.e("request WRITE_EXTERNAL_STORAGE and CAMERA success");
                            requestPermission.onRequestPermissionSuccess();
                        } else {
                            requestPermission.onRequestPermissionFailed();
                        }
                    });
        }
    }

    public static void readExternalStorage(final RequestPermission requestPermission, RxPermissions rxPermissions) {
        boolean isPermissionsGranted =
                rxPermissions
                        .isGranted(Manifest.permission.READ_EXTERNAL_STORAGE);

        if (isPermissionsGranted) {//已经申请过，直接执行操作
            requestPermission.onRequestPermissionSuccess();
        } else {//没有申请过，则申请
            rxPermissions
                    .request(Manifest.permission.READ_EXTERNAL_STORAGE)
                    .subscribe(aBoolean -> {
                        if (aBoolean) {
                            KLog.e("request READ_EXTERNAL_STORAGE");
                            requestPermission.onRequestPermissionSuccess();
                        } else {
                            requestPermission.onRequestPermissionFailed();
                        }
                    });
        }
    }
}
