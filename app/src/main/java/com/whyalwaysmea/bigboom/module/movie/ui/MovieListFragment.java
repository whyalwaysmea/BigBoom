package com.whyalwaysmea.bigboom.module.movie.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseFragment;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListFragment extends BaseFragment {

    public static MovieListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
    }
}
