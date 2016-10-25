package com.whyalwaysmea.bigboom.module.moviedetail.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpFragment;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.module.moviedetail.presenter.MovieReviewPresenterImp;
import com.whyalwaysmea.bigboom.module.moviedetail.ui.adapter.ReviewAdapter;
import com.whyalwaysmea.bigboom.module.moviedetail.view.IMovieView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.whyalwaysmea.bigboom.R.id.lv;

/**
 * Created by Long
 * on 2016/10/18.
 */

public class ReviewFragment extends MvpFragment<IMovieView, MovieReviewPresenterImp> implements IMovieView{

    @BindView(lv)
    RecyclerView mRecyclerview;

    private LinearLayoutManager mLinearLayoutManager;
    private ReviewAdapter mReviewAdapter;
    private List<Review.ReviewsBean> mReviewsBeanList;
    private String mId;

    public static ReviewFragment newInstance(String id) {

        Bundle args = new Bundle();

        ReviewFragment fragment = new ReviewFragment();
        args.putString(Constants.KEY.ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected MovieReviewPresenterImp createPresenter(BaseView view) {
        return new MovieReviewPresenterImp(this);
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

        mReviewsBeanList = new ArrayList<>();
        mReviewAdapter = new ReviewAdapter(mContext, mReviewsBeanList);
        mRecyclerview.setAdapter(mReviewAdapter);

        mPresenter.getReview(mId);
    }


    @Override
    public void setReviewData(List<Review.ReviewsBean> review) {
        mReviewAdapter.addData(review);
    }
}
