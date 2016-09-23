package com.whyalwaysmea.bigboom.module.moviedetail.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.module.moviedetail.view.IMovieDetailView;

/**
 * Created by Long
 * on 2016/9/20.
 */
public class MovieDetailPresenterImp extends BasePresenter<IMovieDetailView> implements IMovieDetailPresenter {

    public MovieDetailPresenterImp(IMovieDetailView iMovieDetailView) {
        super(iMovieDetailView);
    }
}
