package com.whyalwaysmea.bigboom.view.movielist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.MainActivity;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseFragment;
import com.whyalwaysmea.bigboom.widget.SearchView;

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
//        fragments.add(WeeklyMovieFragment.newInstance());
        fragments.add(Top250MovieListFragment.newInstance());
        mViewPager.setAdapter(new MainAdapter(getChildFragmentManager(), titles, fragments));
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setSelectedTabIndicatorColor(getContext().getResources().getColor(R.color.material_white));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_search) {
            showSearch();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSearch() {
        SearchView searchView = new SearchView(mContext, mToolbar, s -> {
            Intent intent = new Intent(mContext, SearchMovieListActivity.class);
            intent.putExtra(Constants.KEY.SEARCH_KEY, s.toString());
            mContext.startActivity(intent);
        });
        searchView.setTransparent();

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
