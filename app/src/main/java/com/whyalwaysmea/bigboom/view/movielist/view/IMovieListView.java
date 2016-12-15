package com.whyalwaysmea.bigboom.view.movielist.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;

/**
 * Created by Long
 * on 2016/9/5.
 */
public interface IMovieListView extends BaseView{

    void setData(MovieListResponse movieListResponse);

}
