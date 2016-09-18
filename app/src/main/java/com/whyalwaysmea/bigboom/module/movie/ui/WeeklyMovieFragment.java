package com.whyalwaysmea.bigboom.module.movie.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;
import com.whyalwaysmea.bigboom.module.movie.presenter.WeeklyMoviePresenterImp;
import com.whyalwaysmea.bigboom.module.movie.ui.adapter.NewMoviesAdapter;
import com.whyalwaysmea.bigboom.module.movie.ui.adapter.WeeklyMoviesAdapter;
import com.whyalwaysmea.bigboom.module.movie.view.IWeeklyMoviesView;
import com.whyalwaysmea.bigboom.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Long
 * on 2016/9/15.
 */
public class WeeklyMovieFragment extends MvpFragment<IWeeklyMoviesView, WeeklyMoviePresenterImp> implements IWeeklyMoviesView, MyRecyclerView.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.recyclerview)
    MyRecyclerView mRecyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.weekly_viewpager)
    ViewPager mWeeklyViewPager;

    private GridLayoutManager mLayoutManager;
    private List<WeeklyMovieInfo.SubjectsBean> mWeeklyMovieInfos;
    private List<MovieInfo> mNewMoviesInfos;
    private WeeklyMoviesAdapter mWeeklyMoviesAdapter;
    private NewMoviesAdapter mNewMoviesAdapter;
    private int mCurrentPage;
    private Subscription mViewPagerSubscribe;
    private boolean isAutoPlay;

    public static WeeklyMovieFragment newInstance() {

        Bundle args = new Bundle();

        WeeklyMovieFragment fragment = new WeeklyMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected WeeklyMoviePresenterImp createPresenter(BaseView view) {
        return new WeeklyMoviePresenterImp(this);
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_weekly_movies, container, false);
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.material_amber_500, R.color.material_blue_500,
                R.color.material_cyan_500, R.color.material_deep_purple_500);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLayoutManager = new GridLayoutManager(getContext(), 1);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mNewMoviesAdapter);
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        mPresenter.loadWeekly();
        mWeeklyMovieInfos = new ArrayList<>();
        mWeeklyMoviesAdapter = new WeeklyMoviesAdapter(mContext, mWeeklyMovieInfos);
        mWeeklyViewPager.setAdapter(mWeeklyMoviesAdapter);
        mWeeklyViewPager.addOnPageChangeListener(this);

        mNewMoviesInfos = new ArrayList<>();
        mNewMoviesAdapter = new NewMoviesAdapter(mContext, mNewMoviesInfos, true);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setWeeklyData(WeeklyMovieInfo weeklyMovieInfo) {
        for (int i = 0; i < weeklyMovieInfo.getSubjects().size() + 2; i++) {
            if (i == 0) {
                mWeeklyMovieInfos.add(weeklyMovieInfo.getSubjects().get(weeklyMovieInfo.getSubjects().size() - 1));
            } else if (i == weeklyMovieInfo.getSubjects().size() + 1) {
                mWeeklyMovieInfos.add(weeklyMovieInfo.getSubjects().get(0));
            } else {
                mWeeklyMovieInfos.add(weeklyMovieInfo.getSubjects().get(i - 1));
            }
        }
        if (weeklyMovieInfo.getSubjects().size() > 3) {
            isAutoPlay = true;
        } else {
            isAutoPlay = false;
        }
        mWeeklyMoviesAdapter.notifyDataSetChanged();
        ViewPagerInterval();
    }

    @Override
    public void setNewMoviesData(MovieListResponse movieListResponse) {

    }

    private void ViewPagerInterval() {
        mCurrentPage = 1;
        mWeeklyViewPager.setCurrentItem(mCurrentPage);
        mViewPagerSubscribe = Observable.interval(5, 5, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        if (mWeeklyMovieInfos != null && mWeeklyMovieInfos.size() > 0 && isAutoPlay) {
                            mCurrentPage++;
                            mWeeklyViewPager.setCurrentItem(mCurrentPage);
                        }
                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mViewPagerSubscribe.isUnsubscribed()) {
            mViewPagerSubscribe.unsubscribe();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (mWeeklyViewPager.getCurrentItem() == 0) {
            mCurrentPage = 1;
        }
        switch (state) {
            // 闲置中
            case ViewPager.SCROLL_STATE_IDLE:
                // “偷梁换柱”
                if (mWeeklyViewPager.getCurrentItem() == 0) {
                    mWeeklyViewPager.setCurrentItem(mWeeklyMovieInfos.size() - 2, false);
                } else if (mWeeklyViewPager.getCurrentItem() == mWeeklyMovieInfos.size() - 1) {
                    mWeeklyViewPager.setCurrentItem(1, false);
                }
                mCurrentPage = mWeeklyViewPager.getCurrentItem();
                isAutoPlay = true;
                break;
            // 拖动中
            case ViewPager.SCROLL_STATE_DRAGGING:
                isAutoPlay = false;
                break;
            // 设置中
            case ViewPager.SCROLL_STATE_SETTLING:
                isAutoPlay = true;
                break;
        }
    }
}
