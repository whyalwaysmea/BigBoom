package com.whyalwaysmea.bigboom.module.moviedetail.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.module.moviedetail.presenter.MovieDetailPresenterImp;
import com.whyalwaysmea.bigboom.module.moviedetail.view.IMovieDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends MvpActivity<IMovieDetailView, MovieDetailPresenterImp> implements IMovieDetailView {

    @BindView(R.id.movie_detail_bg)
    ImageView mMovieDetailBg;
    @BindView(R.id.movie_detail_img)
    ImageView mMovieDetailImg;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.movie_detail_toolbarlayout)
    CollapsingToolbarLayout mMovieDetailToolbarlayout;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.movie_detail_appbarlayout)
    AppBarLayout mMovieDetailAppbarlayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    protected MovieDetailPresenterImp createPresenter(BaseView view) {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
