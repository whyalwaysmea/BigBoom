package com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.whyalwaysmea.bigboom.base.BaseFragment;

import java.util.List;

/**
 * Created by Long
 * on 2016/10/18.
 */

public class CommentPageAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;
    private String[] titles;

    public CommentPageAdapter(FragmentManager fm, String[] titles, List<BaseFragment> fragments) {
        super(fm);
        this.titles = titles;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
