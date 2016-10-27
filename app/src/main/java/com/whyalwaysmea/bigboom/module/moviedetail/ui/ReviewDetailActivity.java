package com.whyalwaysmea.bigboom.module.moviedetail.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReviewDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.review_title)
    TextView mReviewTitle;
    @BindView(R.id.author_avatar)
    ImageView mAuthorAvatar;
    @BindView(R.id.author_name)
    TextView mAuthorName;
    @BindView(R.id.review_time)
    TextView mReviewTime;
    @BindView(R.id.review_content)
    TextView mReviewContent;
    @BindView(R.id.to_top)
    FloatingActionButton mToTop;
    @BindView(R.id.nsv)
    NestedScrollView mNsv;


    private Review.ReviewsBean mReviewsBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_detail);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    protected void initData() {
        mReviewsBean = (Review.ReviewsBean) getIntent().getSerializableExtra(Constants.KEY.REVIEW);
        String title = getIntent().getStringExtra(Constants.KEY.TITLE);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(AppCompatResources.getDrawable(this, R.drawable.icon_back));

        mReviewTitle.setText(mReviewsBean.getTitle());
        mAuthorName.setText(mReviewsBean.getAuthor().getName());
        mReviewTime.setText(mReviewsBean.getCreated_at());
        mReviewContent.setText(mReviewsBean.getContent());

        ImageUtils.getInstance().displayCircleImg(mAuthorAvatar, mReviewsBean.getAuthor().getAvatar());
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.to_top)
    public void toTop() {
        mNsv.smoothScrollTo(0, 0);
    }
}
