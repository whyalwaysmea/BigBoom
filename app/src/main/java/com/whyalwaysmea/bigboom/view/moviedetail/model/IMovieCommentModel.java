package com.whyalwaysmea.bigboom.view.moviedetail.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.Comment;

/**
 * Created by Long
 * on 2016/10/26.
 */

public interface IMovieCommentModel extends BaseModel{
    void loadMovieComments(String id, OnLoadCompleteListener<Comment> loadCompleteListener);

}
