package com.whyalwaysmea.bigboom.module.player;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.eventbus.RxBus;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


/**
 * Created by Long
 * on 2016/11/14.
 */

public class CustomSmallMediaController extends MediaController {

    private ImageButton img_back;//返回按钮
    private VideoView videoView;
    private Activity activity;
    private Context context;


    //返回监听
    private OnClickListener backListener;


    //videoview 用于对视频进行控制的等，activity为了退出
    public CustomSmallMediaController(Context context, VideoView videoView, Activity activity) {
        super(context);
        this.context = context;
        this.videoView = videoView;
        this.activity = activity;
    }


    @Override
    protected View makeControllerView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.layout_media_controller_small, null);
        img_back = (ImageButton) v.findViewById(R.id.mediacontroller_top_back);
        img_back.setOnClickListener(backListener);

        ImageView fullScreen = (ImageView) v.findViewById(R.id.full_screen);
        fullScreen.setOnClickListener(v1 -> {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            RxBus.getInstance().send(Constants.CONFIG.ORIENTATION_LANDSCAPE);
        });
        return v;
    }


    public void setBackListener(OnClickListener backListener) {
        this.backListener = backListener;
    }
}
