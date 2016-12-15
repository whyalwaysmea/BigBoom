package com.whyalwaysmea.bigboom.view.player;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.bean.MovieVideo;
import com.whyalwaysmea.bigboom.view.player.adapter.MovieVideoAdapter;
import com.whyalwaysmea.bigboom.widget.GridMarginDecoration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.CenterLayout;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.BaseCacheStuffer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.SpannedCacheStuffer;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;
import master.flame.danmaku.ui.widget.DanmakuView;
import rx.Observable;

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
    @BindView(R.id.centerlayout)
    CenterLayout mCenterlayout;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;
    @BindView(R.id.danmakuView)
    DanmakuView mDanmakuView;

    private CustomMediaController mCustomMediaController;
    private MediaController mMediaController;
    private Uri uri;

    private MovieVideoAdapter mMovieVideoAdapter;
    private DanmakuContext mDanmakuContext;
    private BaseDanmakuParser mParser;
    private BaseCacheStuffer.Proxy mCacheStufferAdapter = new BaseCacheStuffer.Proxy() {
        @Override
        public void prepareDrawing(BaseDanmaku danmaku, boolean fromWorkerThread) {
            if (danmaku.text instanceof Spanned) { // 根据你的条件检查是否需要需要更新弹幕

            }
        }

        @Override
        public void releaseResource(BaseDanmaku danmaku) {
            // TODO 重要:清理含有ImageSpan的text中的一些占用内存的资源 例如drawable
            if (danmaku.text instanceof Spanned) {
                danmaku.text = "";
            }
        }
    };
    private int mOldPosition;
    private long mOldPlayTime;

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
        if(savedInstanceState != null) {
            mOldPosition = savedInstanceState.getInt(Constants.KEY.POSITION);
            mOldPlayTime = savedInstanceState.getLong(Constants.KEY.CURRENT_TIME);
        }



        ButterKnife.bind(this);
        initView();
        initData();
        initDanma();
    }

    @Override
    protected void initView() {
        mMediaController = new MediaController(this);
        mCustomMediaController = new CustomMediaController(this, mVideoView, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mVideoRecyclerview.setLayoutManager(gridLayoutManager);
        mVideoRecyclerview.addItemDecoration(new GridMarginDecoration(getResources().getDimensionPixelOffset(R.dimen.gridlayout_margin_decoration2)));

        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(true));
    }

    @Override
    protected void initData() {
        MovieDetail movieDetail = (MovieDetail) getIntent().getSerializableExtra(Constants.KEY.MOVIE_URLS);
        List<MovieVideo> movieVideoList = new ArrayList<>();

        List<MovieDetail.ClipsBean> clipsBeanList = new ArrayList<>();
        clipsBeanList.addAll(movieDetail.getBloopers());
        clipsBeanList.addAll(movieDetail.getTrailers());
        clipsBeanList.addAll(movieDetail.getClips());
        Observable.from(clipsBeanList)
                .subscribe(clipsBean -> {
                    movieVideoList.add(new MovieVideo(clipsBean.getResource_url(), clipsBean.getMedium(), clipsBean.getTitle()));
                });

        mMovieVideoAdapter = new MovieVideoAdapter(this);
        mVideoRecyclerview.setAdapter(mMovieVideoAdapter);
        mMovieVideoAdapter.addData(movieVideoList);

        if (movieVideoList.isEmpty()) {
            return;
        }

        uri = Uri.parse(movieVideoList.get(mOldPosition).getUrl());
        mMovieVideoAdapter.setPlayingPosition(mOldPosition);
        mMovieVideoAdapter.notifyDataSetChanged();

        mVideoView.setVideoURI(uri);//设置视频播放地址
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//高画质

        mVideoView.setMediaController(mCustomMediaController);
        mVideoView.seekTo(mOldPlayTime);
        mMediaController.show(5000);
        mVideoView.requestFocus();
        mVideoView.setOnInfoListener(this);
        mVideoView.setOnBufferingUpdateListener(this);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
                mSwiperefreshlayout.setRefreshing(false);
                mSwiperefreshlayout.setEnabled(false);
                mCustomMediaController.setVideoName(movieDetail.getTitle() + "--" + movieVideoList.get(mMovieVideoAdapter.getPlayingPosition()).getTitle());

                // 横屏竖屏高度切换
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    mCenterlayout.setLayoutParams(params);
                    mCustomMediaController.showControllerView();
                    mCustomMediaController.setFullScreen(true);
                } else {
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    mCenterlayout.setLayoutParams(params);
                    mCustomMediaController.hideControllerView();
                    mCustomMediaController.setFullScreen(false);
                }
            }
        });

        mCustomMediaController.setBackListener(v -> {
            if (mCustomMediaController.isFullScreen()) {
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
            } else {
                finish();
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
            if (mMovieVideoAdapter.getPlayingPosition() < (movieVideoList.size() - 1)) {
                int playingPosition = mMovieVideoAdapter.getPlayingPosition();
                mVideoView.setVideoURI(Uri.parse(movieVideoList.get(playingPosition + 1).getUrl()));
                mVideoView.start();
                mMovieVideoAdapter.setPlayingPosition(playingPosition + 1);
                mMovieVideoAdapter.notifyDataSetChanged();
            }
        });

    }


    public void initDanma() {
        // 设置弹幕的最大显示行数
        HashMap<Integer, Integer> maxLinesPair = new HashMap<Integer, Integer>();
        maxLinesPair.put(BaseDanmaku.TYPE_SCROLL_RL, 2); // 滚动弹幕最大显示2行
        // 设置是否禁止重叠
        HashMap<Integer, Boolean> overlappingEnablePair = new HashMap<Integer, Boolean>();
        overlappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_LR, true);
        overlappingEnablePair.put(BaseDanmaku.TYPE_FIX_BOTTOM, true);

        mDanmakuContext = DanmakuContext.create();
        mDanmakuContext
                .setDanmakuStyle(IDisplayer.DANMAKU_STYLE_NONE)
                .setDuplicateMergingEnabled(false)
                .setScrollSpeedFactor(1.2f)//越大速度越慢
                .setScaleTextSize(1.2f)
//                .setCacheStuffer(new BackgroundCacheStuffer(), mCacheStufferAdapter)
                .setCacheStuffer(new SpannedCacheStuffer(), mCacheStufferAdapter) // 图文混排使用SpannedCacheStuffer  设置缓存绘制填充器，默认使用{@link SimpleTextCacheStuffer}只支持纯文字显示, 如果需要图文混排请设置{@link SpannedCacheStuffer}如果需要定制其他样式请扩展{@link SimpleTextCacheStuffer}|{@link SpannedCacheStuffer}
                .setMaximumLines(maxLinesPair)          // 设置最大显示行数
                .preventOverlapping(overlappingEnablePair);  //设置防弹幕重叠，null为允许重叠

        // 对DanmuView进行配置
        if (mDanmakuView != null) {
            //创建解析器对象，从raw资源目录下解析comments.xml文本
            mParser = createParser(this.getResources().openRawResource(R.raw.comments));

            mDanmakuView.setCallback(new DrawHandler.Callback() {
                @Override
                public void prepared() {
                    mDanmakuView.start();
                }

                @Override
                public void updateTimer(DanmakuTimer timer) {

                }

                @Override
                public void danmakuShown(BaseDanmaku danmaku) {

                }

                @Override
                public void drawingFinished() {

                }
            });
        }
        mDanmakuView.showFPS(false);
        mCustomMediaController.initDanmu(mDanmakuView, mDanmakuContext, mParser);
        mDanmakuView.enableDanmakuDrawingCache(true);
    }

    /**
     * 创建解析器对象，解析输入流
     *
     * @param stream
     * @return
     */
    private BaseDanmakuParser createParser(InputStream stream) {
        if (stream == null) {
            return new BaseDanmakuParser() {
                @Override
                protected Danmakus parse() {
                    return new Danmakus();
                }
            };
        }
        ILoader loader = DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_BILI);
        try {
            loader.load(stream);
        } catch (IllegalDataException e) {
            e.printStackTrace();
        }
        BaseDanmakuParser parser = new BiliDanmukuParser();
        IDataSource<?> dataSource = loader.getDataSource();
        parser.load(dataSource);
        return parser;
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
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(Constants.KEY.POSITION, mMovieVideoAdapter.getPlayingPosition());
        outState.putLong(Constants.KEY.CURRENT_TIME, mVideoView.getCurrentPosition());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        mLoadRate.setText(percent + "%");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDanmakuView != null) {
            // dont forget release!
            mDanmakuView.release();
            mDanmakuView = null;
        }
    }

}
