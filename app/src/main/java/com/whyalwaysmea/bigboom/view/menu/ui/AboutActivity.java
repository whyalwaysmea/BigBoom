package com.whyalwaysmea.bigboom.view.menu.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;
import com.whyalwaysmea.bigboom.utils.Blur;
import com.whyalwaysmea.bigboom.utils.MeasureUtil;
import com.whyalwaysmea.bigboom.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.whyalwaysmea.bigboom.R.id.head_layout;

public class AboutActivity extends BaseActivity {

    @BindView(head_layout)
    LinearLayout mHeadLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.about_app)
    TextView mAboutApp;
    @BindView(R.id.version)
    TextView mVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // 设置全屏，并且不会Activity的布局让出状态栏的空间
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(this);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            // 设置Toolbar对顶部的距离
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mImg.getLayoutParams();
            params.topMargin = -MeasureUtil.getStatusBarHeight(this);
            mImg.setLayoutParams(params);
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // 设置Toolbar对顶部的距离
            final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) toolbar
                    .getLayoutParams();
            layoutParams.topMargin = MeasureUtil.getStatusBarHeight(this);
        }
        initView();
        initData();
    }

    @Override
    protected void initView() {
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(view -> finish());

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.about_bg);
        mImg.setImageBitmap(Blur.apply(bitmap));

        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset <= -mImg.getHeight() / 2) {
                mCollapsingToolbarLayout.setTitle(getResources().getString(R.string.whyalwaysmea));
            } else {
                mCollapsingToolbarLayout.setTitle("");
            }
        });

    }

    @Override
    protected void initData() {
        mHeadLayout.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, GithubActivity.class);
            startActivity(intent);
        });

        SpannableString spannableString = new SpannableString(getResources().getString(R.string.about_app));
        spannableString.setSpan(new URLSpan("https://developers.douban.com/"), 23, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mAboutApp.setText(spannableString);
        mAboutApp.setMovementMethod(LinkMovementMethod.getInstance());

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_CONFIGURATIONS);
            String versionName = packageInfo.versionName;
            mVersion.setText(getResources().getString(R.string.version, versionName));

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
