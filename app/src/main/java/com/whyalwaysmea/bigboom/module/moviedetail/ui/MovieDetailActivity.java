package com.whyalwaysmea.bigboom.module.moviedetail.ui;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

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

public class MovieDetailActivity extends MvpActivity<IMovieDetailView, MovieDetailPresenterImp> implements IMovieDetailView {

    @BindView(R.id.movie_detail_bg)
    ImageView mMovieDetailBg;
    @BindView(R.id.movie_detail_img)
    ImageView mMovieDetailImg;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.movie_detail_toolbarlayout)
    CollapsingToolbarLayout mMovieDetailToolbarlayout;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.movie_detail_appbarlayout)
    AppBarLayout mMovieDetailAppbarlayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.root_view)
    CoordinatorLayout mRootView;

    private int mX, mY;
    private String mId;

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
            final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) toolbar
                    .getLayoutParams();
            layoutParams.topMargin = MeasureUtil.getStatusBarHeight(this);
        }


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
        ImageUtils.getInstance().display(mMovieDetailImg, detailData.getImages().getLarge());
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
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, mX, mY);
            animator.start();
        } else {
            finish();
        }
    }
}
