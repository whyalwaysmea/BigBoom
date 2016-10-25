package com.whyalwaysmea.bigboom.module.moviedetail.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.Review;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/24.
 */

public class ReviewAdapter extends BaseAdapter<Review.ReviewsBean> {


    public ReviewAdapter(Context context, List<Review.ReviewsBean> data) {
        super(context, data);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_review, parent, false);
        return new ReviewHolder(view);
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

        }
    }
}
