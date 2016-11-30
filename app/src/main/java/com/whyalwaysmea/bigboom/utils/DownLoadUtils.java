package com.whyalwaysmea.bigboom.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;

import com.whyalwaysmea.bigboom.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long
 * on 2016/11/9.
 */

public class DownLoadUtils {
    public static Uri saveImage(Context context, String desc, Bitmap bitmap, DownloadListener downloadListener) {
        String imgDir = Constants.URL.DOWNLOAD_URL;

        String fileName = desc + ".png";

        File fileDir = new File(imgDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }

        File imageFile = new File(fileDir, fileName);
        if (!imageFile.exists()) {
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


    public static List<String> getPictures() {
        List<String> list = new ArrayList<String>();
        String imgDir = Constants.URL.DOWNLOAD_URL;
        File file = new File(imgDir);
        File[] allfiles = file.listFiles();
        if (allfiles == null) {
            return null;
        }
        for (int k = 0; k < allfiles.length; k++) {
            final File fi = allfiles[k];
            if (fi.isFile()) {
                int idx = fi.getPath().lastIndexOf(".");
                if (idx <= 0) {
                    continue;
                }
                String suffix = fi.getPath().substring(idx);
                if (suffix.toLowerCase().equals(".jpg") ||
                        suffix.toLowerCase().equals(".jpeg") ||
                        suffix.toLowerCase().equals(".bmp") ||
                        suffix.toLowerCase().equals(".png") ||
                        suffix.toLowerCase().equals(".gif")) {
                    list.add(fi.getPath());
                }
            }
        }
        return list;
    }


}
