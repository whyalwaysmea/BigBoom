package com.whyalwaysmea.bigboom.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.whyalwaysmea.bigboom.R;

/**
 * Created by Long
 * on 2016/10/31.
 */

public class ShareUtils {
    private ShareUtils() {
        throw new UnsupportedOperationException("u can't fuck me...");
    }

    /**
     * 分享
     *
     * @param context
     * @param content 分享内容
     * @param uri     分享图片uri
     */
    public static void share(Context context, String content, Uri uri) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        if (uri != null) {
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("image/*");
            //当用户选择短信时使用sms_body取得文字
            shareIntent.putExtra("sms_body", content);
        } else {
            shareIntent.setType("text/plain");
        }
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        context.startActivity(Intent.createChooser(shareIntent, context.getString(R.string.share)));
    }

}
