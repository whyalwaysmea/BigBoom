package com.whyalwaysmea.bigboom.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.leakcanary.RefWatcher;
import com.whyalwaysmea.bigboom.App;

import butterknife.ButterKnife;

/**
 * Created by Long
 * on 2016/9/5.
 */
public abstract class BaseFragment extends Fragment{

    protected View mRootView;
    protected Context mContext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRootView(inflater, container);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

    }

    protected void init() {
        mContext = getActivity();
        initView();
        initData();
    }

    protected abstract void initRootView(LayoutInflater inflater, ViewGroup container) ;

    protected abstract void initView();

    protected abstract void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.sRefWatcher;
        refWatcher.watch(this);
    }
}
