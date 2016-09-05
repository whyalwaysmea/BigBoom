package com.whyalwaysmea.bigboom.module.movie.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.module.movie.view.IMovieListView;

/**
 * Created by Long
 * on 2016/9/5.
 */
public class MovieListPresenterImp extends BasePresenter<IMovieListView> implements IMovieListPresenter {

    public MovieListPresenterImp(IMovieListView iMovieListView) {
        super(iMovieListView);
    }
}
