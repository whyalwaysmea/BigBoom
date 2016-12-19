package com.whyalwaysmea.bigboom.view.moviedetail.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.Comment;
import com.whyalwaysmea.bigboom.di.component.DaggerMovieComponent;
import com.whyalwaysmea.bigboom.di.module.MovieModule;
import com.whyalwaysmea.bigboom.view.moviedetail.presenter.MovieCommentPresenterImp;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter.CommentAdapter;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieCommentView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/18.
 */

public class CommentFragment extends MvpFragment<IMovieCommentView, MovieCommentPresenterImp> implements IMovieCommentView{

    @BindView(R.id.lv)
    RecyclerView mRecyclerview;

    private LinearLayoutManager mLinearLayoutManager;
    private CommentAdapter mCommentAdapter;
    private List<Comment.CommentsBean> mCommentsBeanList;
    private String mId;

    @Inject
    MovieCommentPresenterImp mPresenter;

    public static CommentFragment newInstance(String id) {
        
        Bundle args = new Bundle();
        
        CommentFragment fragment = new CommentFragment();
        args.putString(Constants.KEY.ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected MovieCommentPresenterImp createPresenter(BaseView view) {
//        return new MovieCommentPresenterImp(this);
        DaggerMovieComponent
                .builder()
                .movieModule(new MovieModule(this))
                .build()
                .inject(this);


        return null;
    }
    
    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.review_fragment, container, false);
    }

    @Override
    protected void initView() {
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(mLinearLayoutManager);
        mRecyclerview.setNestedScrollingEnabled(false);
        mRecyclerview.setHasFixedSize(false);
    }

    @Override
    protected void initData() {
        mId = getArguments().getString(Constants.KEY.ID);

        mCommentsBeanList = new ArrayList<>();
        mCommentAdapter = new CommentAdapter(mContext);
        mRecyclerview.setAdapter(mCommentAdapter);

        mPresenter.getComment(mId);
    }


    @Override
    public void setComment(List<Comment.CommentsBean> comments) {
        mCommentAdapter.addData(comments);
    }
}
