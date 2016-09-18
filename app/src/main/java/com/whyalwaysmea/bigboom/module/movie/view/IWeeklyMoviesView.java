package com.whyalwaysmea.bigboom.module.movie.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;

/**
 * Created by Long
 * on 2016/9/18.
 */
public interface IWeeklyMoviesView extends BaseView {

    void setWeeklyData(WeeklyMovieInfo weeklyMovieInfo);

    void setNewMoviesData(MovieListResponse movieListResponse);
}
