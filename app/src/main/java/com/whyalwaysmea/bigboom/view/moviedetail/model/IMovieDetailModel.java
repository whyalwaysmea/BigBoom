package com.whyalwaysmea.bigboom.view.moviedetail.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieDetail;

/**
 * Created by Long
 * on 2016/9/20.
 */
public interface IMovieDetailModel extends BaseModel {

    void loadSubject(String id, OnLoadCompleteListener<MovieDetail> listener);
}
