package com.whyalwaysmea.bigboom.module.moviedetail.ui;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.BitmapTypeRequest;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.module.moviedetail.presenter.MovieDetailPresenterImp;
import com.whyalwaysmea.bigboom.module.moviedetail.view.IMovieDetailView;
import com.whyalwaysmea.bigboom.utils.MeasureUtil;
import com.whyalwaysmea.bigboom.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.whyalwaysmea.bigboom.R.id.toolbar;

public class MovieDetailActivity extends MvpActivity<IMovieDetailView, MovieDetailPresenterImp> implements IMovieDetailView {

    @BindView(R.id.movie_detail_bg)
    ImageView mMovieDetailBg;
    @BindView(toolbar)
    Toolbar mToolbar;
    @BindView(R.id.movie_detail_toolbarlayout)
    CollapsingToolbarLayout mMovieDetailToolbarlayout;
    @BindView(R.id.movie_detail_appbarlayout)
    AppBarLayout mMovieDetailAppbarlayout;
    @BindView(R.id.root_view)
    CoordinatorLayout mRootView;
    @BindView(R.id.progress)
    ContentLoadingProgressBar mProgress;
    @BindView(R.id.pubdate)
    TextView mPubdate;
    @BindView(R.id.original_title)
    TextView mOriginalTitle;
    @BindView(R.id.durations)
    TextView mDurations;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private int mX, mY;
    private String mId;
    private BitmapTypeRequest<String> mStringBitmapTypeRequest;

    @Override
    protected MovieDetailPresenterImp createPresenter(BaseView view) {
        return new MovieDetailPresenterImp(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // 设置全屏，并且不会Activity的布局让出状态栏的空间
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        mPresenter = createPresenter(this);
        StatusBarUtil.setTransparent(this);
        initView();
        initData();
    }

    @Override
    protected void initData() {
        mPresenter.loadSubject(mId);
    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // 设置Toolbar对顶部的距离
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mToolbar
                    .getLayoutParams();
            layoutParams.topMargin = MeasureUtil.getStatusBarHeight(this);
        }

        mToolbar.setNavigationIcon(AppCompatResources.getDrawable(this, R.drawable.ic_action_clear));


        mX = getIntent().getIntExtra("X", 0);
        mY = getIntent().getIntExtra("Y", 0);
        mId = getIntent().getStringExtra("ID");

        mRootView.post(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Animator animator = createRevealAnimator(false, mX, mY);
                    animator.start();
                }
            }
        });

    }


    @Override
    public void setDetailData(MovieDetail detailData) {
        ImageUtils.getInstance().display(mMovieDetailBg, detailData.getImages().getLarge());
        mToolbar.setTitle(detailData.getTitle());
        StringBuffer sbPubdate = new StringBuffer();
        sbPubdate.append(detailData.getYear());
        for (int i = 0; i < detailData.getGenres().size(); i++) {
            sbPubdate.append("/");
            sbPubdate.append(detailData.getGenres().get(i));
        }
        mPubdate.setText(sbPubdate.toString());

        mOriginalTitle.setText(getString(R.string.original_title) + detailData.getOriginal_title());
        mDurations.setText(getString(R.string.durations) + detailData.getDurations().get(0));
    }

    // 动画
    private Animator createRevealAnimator(boolean reversed, int x, int y) {
        float hypot = (float) Math.hypot(mRootView.getHeight(), mRootView.getWidth());
        float startRadius = reversed ? hypot : 0;
        float endRadius = reversed ? 0 : hypot;

        Animator animator = ViewAnimationUtils.createCircularReveal(
                mRootView, x, y,
                startRadius,
                endRadius);
        animator.setDuration(800);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        if (reversed)
            animator.addListener(animatorListener);
        return animator;
    }

    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            mRootView.setVisibility(View.INVISIBLE);
            finish();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    };

    @Override
    public void showLoading() {
        super.showLoading();
        mProgress.show();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        mProgress.hide();
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, mX, mY);
            animator.start();
        } else {
            finish();
        }
    }
}
