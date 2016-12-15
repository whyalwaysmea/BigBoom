package com.whyalwaysmea.bigboom.view.moviedetail.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MoviePhoto;

/**
 * Created by Long
 * on 2016/11/11.
 */

public interface IMoviePhotoListModel extends BaseModel {

    void getMoviePhotoList(String id, int start, OnLoadCompleteListener<MoviePhoto> completeListener);

}
