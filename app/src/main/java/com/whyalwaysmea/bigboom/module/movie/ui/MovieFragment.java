package com.whyalwaysmea.bigboom.module.movie.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.base.BaseFragment;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.module.movie.presenter.MovieListPresenterImp;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieFragment extends BaseFragment<IMovieListView, MovieListPresenterImp> {

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {

    }


    @Override
    protected MovieListPresenterImp createPresenter(BaseView view) {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


}
