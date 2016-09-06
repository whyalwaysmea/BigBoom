package com.whyalwaysmea.bigboom.module.movie.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.Movie;

/**
 * Created by Long
 * on 2016/9/5.
 */
public interface IMovieListView extends BaseView{

    void refreshData(Movie movie);

    void addData(Movie movie);

}
