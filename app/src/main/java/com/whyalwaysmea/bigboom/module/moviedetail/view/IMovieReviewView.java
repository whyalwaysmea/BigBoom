package com.whyalwaysmea.bigboom.module.moviedetail.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.Review;

import java.util.List;

/**
 * Created by Long
 * on 2016/10/24.
 */

public interface IMovieReviewView extends BaseView{
    void setReviewData(List<Review.ReviewsBean> reviewData);
}
