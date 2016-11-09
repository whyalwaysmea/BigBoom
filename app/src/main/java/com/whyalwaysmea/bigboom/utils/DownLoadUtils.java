package com.whyalwaysmea.bigboom.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import com.socks.library.KLog;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Long
 * on 2016/11/9.
 */

public class DownLoadUtils {
    public static Uri saveImage(Context context, String desc, Bitmap bitmap, DownloadListener downloadListener) {
        String imgDir = Environment.getExternalStorageDirectory().getPath() + "/BitBoom";
        String fileName = desc + ".png";

        File fileDir = new File(imgDir);
        if (!fileDir.exists())
            fileDir.mkdir();

        File imageFile = new File(fileDir, fileName);
        if (!imageFile.exists()){
            try {
                FileOutputStream fos = new FileOutputStream(imageFile);
                boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                if (compress) {
                    downloadListener.success();
                } else {
                    downloadListener.failed();
                }

                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            downloadListener.exists();
        }

        Uri uri = Uri.fromFile(imageFile);
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        return uri;
    }

    public interface DownloadListener {
        void success();
        void failed();
        void exists();
    }

}
