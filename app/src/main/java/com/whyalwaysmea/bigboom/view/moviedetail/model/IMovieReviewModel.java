package com.whyalwaysmea.bigboom.view.moviedetail.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Review;

/**
 * Created by Long
 * on 2016/10/24.
 */

public interface IMovieReviewModel extends BaseModel {

    void loadMovieReview(String id, OnLoadCompleteListener<Review> loadCompleteListener);

}
