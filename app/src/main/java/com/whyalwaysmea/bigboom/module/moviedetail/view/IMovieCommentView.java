package com.whyalwaysmea.bigboom.module.moviedetail.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.Comment;

import java.util.List;

/**
 * Created by Long
 * on 2016/10/26.
 */

public interface IMovieCommentView extends BaseView{
    void setComment(List<Comment.CommentsBean> comments);
}
