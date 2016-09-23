package com.whyalwaysmea.bigboom.module.movielist.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.MainActivity;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieFragment extends BaseFragment {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private List<BaseFragment> fragments;
    private String[] titles;

    public static MovieFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    
    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_movie, container, false);
    }


    @Override
    protected void initView() {
        ((MainActivity) getActivity()).setToolbar(mToolbar);

    }

    @Override
    protected void initData() {
        titles = getResources().getStringArray(R.array.movie_titles);
        fragments = new ArrayList<>();
        fragments.add(InTheatersMovieListFragment.newInstance());
        fragments.add(ComingSoonFragment.newInstance());
        fragments.add(WeeklyMovieFragment.newInstance());
        for (int i = 0; i < titles.length-3; i++) {
            fragments.add(Top250MovieListFragment.newInstance());

        }
        mViewPager.setAdapter(new MainAdapter(getChildFragmentManager(), titles, fragments));
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setCurrentItem(2);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setSelectedTabIndicatorColor(getContext().getResources().getColor(R.color.material_white));
    }

    class MainAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;
        private final String[] titles;

        public MainAdapter(FragmentManager fm, String[] titles, List<BaseFragment> fragments) {
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

}
