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
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.di.component.DaggerMovieComponent;
import com.whyalwaysmea.bigboom.di.module.MovieModule;
import com.whyalwaysmea.bigboom.view.moviedetail.presenter.MovieReviewPresenterImp;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter.ReviewAdapter;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieReviewView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/18.
 */

public class ReviewFragment extends MvpFragment<IMovieReviewView, MovieReviewPresenterImp> implements IMovieReviewView {

    @BindView(R.id.lv)
    RecyclerView mRecyclerview;

    private LinearLayoutManager mLinearLayoutManager;
    private ReviewAdapter mReviewAdapter;
    private List<Review.ReviewsBean> mReviewsBeanList;
    private String mId;

    @Inject
    MovieReviewPresenterImp mPresenter;

    public static ReviewFragment newInstance(String id) {

        Bundle args = new Bundle();

        ReviewFragment fragment = new ReviewFragment();
        args.putString(Constants.KEY.ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected MovieReviewPresenterImp createPresenter(BaseView view) {
//        return new MovieReviewPresenterImp(this);
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

        mReviewsBeanList = new ArrayList<>();
        mReviewAdapter = new ReviewAdapter(mContext);
        mRecyclerview.setAdapter(mReviewAdapter);

        mPresenter.getReview(mId);
    }


    @Override
    public void setReviewData(Review review) {
        mReviewAdapter.addData(review.getReviews());
        mReviewAdapter.setMovieTitle(review.getSubject().getTitle());
    }
}
