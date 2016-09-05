package com.whyalwaysmea.bigboom.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Long
 * on 2016/9/2.
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements BaseView {

    protected P mPresenter;
    protected View mRootView;


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
        initView();
        initData();
        mPresenter = createPresenter(this);

    }

    protected abstract P createPresenter(BaseView view);

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initRootView(LayoutInflater inflater, ViewGroup container) ;


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
