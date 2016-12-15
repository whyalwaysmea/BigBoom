package com.whyalwaysmea.bigboom.view.moviedetail.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReviewDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.review_title)
    TextView mReviewTitle;
    @BindView(R.id.author_avatar)
    ImageView mAuthorAvatar;
    @BindView(R.id.author_name)
    TextView mAuthorName;
    @BindView(R.id.review_time)
    TextView mReviewTime;
    @BindView(R.id.review_content)
    TextView mReviewContent;
    @BindView(R.id.to_top)
    FloatingActionButton mToTop;
    @BindView(R.id.nsv)
    NestedScrollView mNsv;
    @BindView(R.id.activity_review_detail)
    CoordinatorLayout mActivityReviewDetail;


    private Review.ReviewsBean mReviewsBean;
    private int mTop;
    private int mLeft;
    private int mWidth;
    private int mHeight;
    private int mDeltaX;
    private int mDeltaY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        mReviewsBean = (Review.ReviewsBean) getIntent().getSerializableExtra(Constants.KEY.REVIEW);
        Bundle bundle = getIntent().getBundleExtra(Constants.KEY.VIEW_INFO);

        mTop = bundle.getInt(Constants.VIEW.TOP);
        mLeft = bundle.getInt(Constants.VIEW.LEFT);
        mWidth = bundle.getInt(Constants.VIEW.WIDTH);
        mHeight = bundle.getInt(Constants.VIEW.HEIGHT);

        ImageUtils.getInstance().displayCircleImg(this, mReviewsBean.getAuthor().getAvatar(), new GlideDrawableImageViewTarget(mAuthorAvatar) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                super.onResourceReady(resource, animation);
                // 加载完成
                onUiReady();
            }
        });
    }

    private void onUiReady() {
        mAuthorAvatar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                // remove previous listener
                mAuthorAvatar.getViewTreeObserver().removeOnPreDrawListener(this);
                // prep the scene
                prepareScene();
                // run the animation
                runEnterAnimation();
                return true;
            }
        });
    }

    private void prepareScene() {

        int[] screenLocation = new int[2];
        mAuthorAvatar.getLocationOnScreen(screenLocation);
        //移动到起始view位置
        mDeltaX = mLeft - screenLocation[0];
        mDeltaY = mTop - screenLocation[1];
        mAuthorAvatar.setTranslationX(mDeltaX);
        mAuthorAvatar.setTranslationY(mDeltaY);
    }

    private void runEnterAnimation() {
        // We can now make it visible
        mAuthorAvatar.setVisibility(View.VISIBLE);
        // finally, run the animation
        mAuthorAvatar.animate()
                .setDuration(300)
                .setInterpolator(new LinearOutSlowInInterpolator())
                .scaleX(1f)
                .scaleY(1f)
                .translationX(0)
                .translationY(0)
                .start();
    }

    @Override
    public void onBackPressed() {
        runExitAnimation();
    }

    private void runExitAnimation() {
        mActivityReviewDetail.animate()
                .alpha(0.6f)
                .setDuration(300)
                .start();


        mAuthorAvatar.animate()
                .setDuration(300)
                .setInterpolator(new FastOutLinearInInterpolator())
                .translationX(mDeltaX)
                .translationY(mDeltaY)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        overridePendingTransition(0, 0);
                    }
                }).start();
    }

    @Override
    protected void initData() {
        String title = getIntent().getStringExtra(Constants.KEY.TITLE);
        mToolbar.setTitle(title);
        mToolbar.setNavigationIcon(AppCompatResources.getDrawable(this, R.drawable.icon_back));
        setSupportActionBar(mToolbar);
        RxToolbar.navigationClicks(mToolbar).subscribe(aVoid -> finish());


        mReviewTitle.setText(mReviewsBean.getTitle());
        mAuthorName.setText(mReviewsBean.getAuthor().getName());
        mReviewTime.setText(mReviewsBean.getCreated_at());
        mReviewContent.setText(mReviewsBean.getContent());

    }


    @OnClick(R.id.to_top)
    public void toTop() {
        mNsv.smoothScrollTo(0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        return true;
    }

}
