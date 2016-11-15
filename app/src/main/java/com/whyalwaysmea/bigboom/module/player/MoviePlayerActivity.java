package com.whyalwaysmea.bigboom.module.player;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.socks.library.KLog;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.bean.MovieVideo;
import com.whyalwaysmea.bigboom.module.player.adapter.MovieVideoAdapter;
import com.whyalwaysmea.bigboom.view.GridMarginDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MoviePlayerActivity extends BaseActivity implements MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {


    @BindView(R.id.buffer)
    VideoView mVideoView;
    @BindView(R.id.probar)
    ProgressBar mProbar;
    @BindView(R.id.download_rate)
    TextView mDownloadRate;
    @BindView(R.id.load_rate)
    TextView mLoadRate;

    @BindView(R.id.video_recyclerview)
    RecyclerView mVideoRecyclerview;

    private CustomMediaController mCustomMediaController;
    private MediaController mMediaController;
    private Uri uri;

    private MovieVideoAdapter mMovieVideoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window = MoviePlayerActivity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        //必须写这个，初始化加载库文件
        Vitamio.isInitialized(this);

        setContentView(R.layout.activity_movie_player);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        mMediaController = new MediaController(this);
        mCustomMediaController = new CustomMediaController(this, mVideoView, this);
        mCustomMediaController.setVideoName("白火锅 x 红火锅");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mVideoRecyclerview.setLayoutManager(gridLayoutManager);
        mVideoRecyclerview.addItemDecoration(new GridMarginDecoration(getResources().getDimensionPixelOffset(R.dimen.gridlayout_margin_decoration2)));
    }

    @Override
    protected void initData() {
        MovieDetail movieDetail = (MovieDetail) getIntent().getSerializableExtra(Constants.KEY.MOVIE_URLS);
        List<MovieVideo> movieVideoList = new ArrayList<>();
        for (int i = 0; i < movieDetail.getClips().size(); i++) {
            MovieDetail.ClipsBean clipsBean = movieDetail.getClips().get(i);
            movieVideoList.add(new MovieVideo(clipsBean.getResource_url(), clipsBean.getMedium(), clipsBean.getTitle()));
        }

        for (int i = 0; i < movieDetail.getTrailers().size(); i++) {
            MovieDetail.TrailersBean clipsBean = movieDetail.getTrailers().get(i);
            movieVideoList.add(new MovieVideo(clipsBean.getResource_url(), clipsBean.getMedium(), clipsBean.getTitle()));
        }

        for (int i = 0; i < movieDetail.getBloopers().size(); i++) {
            MovieDetail.ClipsBean clipsBean = movieDetail.getBloopers().get(i);
            movieVideoList.add(new MovieVideo(clipsBean.getResource_url(), clipsBean.getMedium(), clipsBean.getTitle()));
        }


        mMovieVideoAdapter = new MovieVideoAdapter(this, movieVideoList);
        mVideoRecyclerview.setAdapter(mMovieVideoAdapter);

        if(movieVideoList.isEmpty()) {
            return ;
        }

        uri = Uri.parse(movieVideoList.get(4).getUrl());
        mMovieVideoAdapter.setPlayingPosition(4);
        mMovieVideoAdapter.notifyDataSetChanged();

        mVideoView.setVideoURI(uri);//设置视频播放地址
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//高画质

        mVideoView.setMediaController(mCustomMediaController);
        KLog.e("small");
        mMediaController.show(5000);
        mVideoView.requestFocus();
        mVideoView.setOnInfoListener(this);
        mVideoView.setOnBufferingUpdateListener(this);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });

        mMovieVideoAdapter.setOnClickListener(new BaseAdapter.OnClickListener() {
            @Override
            public void setOnItemClickListener(View view, int position) {
                mVideoView.stopPlayback();
                mVideoView.setVideoURI(Uri.parse(movieVideoList.get(position).getUrl()));
                mVideoView.start();
                mMovieVideoAdapter.setPlayingPosition(position);
                mMovieVideoAdapter.notifyDataSetChanged();
            }
        });

        mVideoView.setOnCompletionListener(mp -> {
            if(mMovieVideoAdapter.getPlayingPosition() < (movieVideoList.size() - 1)) {
                int playingPosition = mMovieVideoAdapter.getPlayingPosition();
                mVideoView.setVideoURI(Uri.parse(movieVideoList.get(playingPosition + 1).getUrl()));
                mVideoView.start();
                mMovieVideoAdapter.setPlayingPosition(playingPosition + 1);
                mMovieVideoAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                    mProbar.setVisibility(View.VISIBLE);
                    mDownloadRate.setText("");
                    mLoadRate.setText("");
                    mDownloadRate.setVisibility(View.VISIBLE);
                    mLoadRate.setVisibility(View.VISIBLE);
                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                mVideoView.start();
                mProbar.setVisibility(View.GONE);
                mDownloadRate.setVisibility(View.GONE);
                mLoadRate.setVisibility(View.GONE);
                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                mDownloadRate.setText("" + extra + "kb/s" + "  ");
                break;
        }
        return true;
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        mLoadRate.setText(percent + "%");
    }


}
