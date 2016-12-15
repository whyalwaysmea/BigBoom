package com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.base.EmptyViewHolder;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.ReviewDetailActivity;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/24.
 */

public class ReviewAdapter extends BaseAdapter<Review.ReviewsBean> {

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    private String movieTitle;

    public ReviewAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_review, parent, false);
        return new ReviewHolder(view);
    }

    @Override
    protected BaseViewHolder onCreateEmptyViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.empty_no_content, parent, false);
        return new EmptyViewHolder(view);
    }

    class ReviewHolder extends BaseViewHolder {

        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.avatart)
        ImageView mAvatart;
        @BindView(R.id.name)
        TextView mName;
        @BindView(R.id.time)
        TextView mTime;
        @BindView(R.id.content)
        TextView mContent;
        @BindView(R.id.all)
        TextView mAll;


        public ReviewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            Review.ReviewsBean review = mData.get(position);

            mTitle.setText(review.getTitle());
            mName.setText(review.getAuthor().getName());
            mTime.setText(review.getCreated_at());
            mContent.setText(review.getSummary());
            ImageUtils.getInstance().displayCircleImg(mAvatart, review.getAuthor().getAvatar());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = captureValues(mAvatart);
                    Intent intent = new Intent(mContext, ReviewDetailActivity.class);
                    intent.putExtra(Constants.KEY.REVIEW, review);
                    intent.putExtra(Constants.KEY.TITLE, getMovieTitle());
                    intent.putExtra(Constants.KEY.VIEW_INFO, bundle);
                    mContext.startActivity(intent);
                    ((Activity)mContext).overridePendingTransition(0, 0);

                    /*Intent intent = new Intent(mContext, ReviewDetailActivity.class);
                    intent.putExtra(Constants.KEY.REVIEW, review);
                    intent.putExtra(Constants.KEY.TITLE, getMovieTitle());
                    if(!TextUtils.isEmpty(getMovieTitle())) {
                        intent.putExtra(Constants.KEY.TITLE, getMovieTitle());
                    }
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) mContext, mAvatart , "shareName");
                    mContext.startActivity(intent, options.toBundle());*/
                }
            });
        }
    }

    private Bundle captureValues(@NonNull View view) {
        Bundle b = new Bundle();
        int[] screenLocation = new int[2];
        view.getLocationOnScreen(screenLocation);
        b.putInt(Constants.VIEW.LEFT, screenLocation[0]);
        b.putInt(Constants.VIEW.TOP, screenLocation[1]);
        b.putInt(Constants.VIEW.WIDTH, view.getWidth());
        b.putInt(Constants.VIEW.HEIGHT, view.getHeight());
        return b;
    }
}
