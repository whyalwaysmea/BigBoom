package com.whyalwaysmea.bigboom.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.utils.SystemBarTintManager;

/**
 * Created by Long
 * on 2016/9/5.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    protected void init() {
        initView();
        initData();
        initSystemBar();
    }

    protected abstract void initData();

    protected abstract void initView();


    protected void addFragmentToStack(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }


    protected void initSystemBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setTranslucentStatus(this, true);
            }
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            // 使用颜色资源
            tintManager.setStatusBarTintResource(getStatusColor());
        }
    }

    protected int getStatusColor() {
        return R.color.colorPrimaryDark;
    }

    @TargetApi(19)
    protected void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();

        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


}
