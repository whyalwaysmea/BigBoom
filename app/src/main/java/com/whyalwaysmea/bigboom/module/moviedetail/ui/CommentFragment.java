package com.whyalwaysmea.bigboom.module.moviedetail.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.base.BaseFragment;

/**
 * Created by Long
 * on 2016/10/18.
 */

public class CommentFragment extends BaseFragment {
    public static CommentFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
