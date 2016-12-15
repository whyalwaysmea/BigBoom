package com.whyalwaysmea.bigboom.view.movielist.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MovieDetailActivity;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/6.
 */
public class Top250MovieAdapter extends BaseAdapter<MovieInfo> {


    public Top250MovieAdapter(Context context, boolean useAnimation) {
        super(context, useAnimation);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.top_movie_item, parent, false);
        return new HotMovieHolder(view);
    }


    class HotMovieHolder extends BaseViewHolder {

        @BindView(R.id.top_movie_item_icon)
        ImageView mTopMovieItemIcon;
        @BindView(R.id.top_movie_item_name)
        TextView mTopMovieItemName;
        @BindView(R.id.top_movie_item_date)
        TextView mTopMovieItemDate;
        @BindView(R.id.top_movie_item_original_name)
        TextView mTopMovieItemOriginalName;
        @BindView(R.id.ratingBar_hots)
        AppCompatRatingBar mRatingBarHots;
        @BindView(R.id.top_movie_item_score)
        TextView mTopMovieItemScore;
        @BindView(R.id.ranking)
        TextView mRanking;

        public HotMovieHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            MovieInfo movieInfo = mData.get(position);

            mTopMovieItemName.setText(movieInfo.getTitle());
            mTopMovieItemOriginalName.setText(movieInfo.getOriginal_title());
            mTopMovieItemDate.setText(mContext.getResources().getString(R.string.start_data) + movieInfo.getYear());
            mRatingBarHots.setRating((float) movieInfo.getRating().getAverage() / 2);
            mTopMovieItemScore.setText("" + movieInfo.getRating().getAverage());
            ImageUtils.getInstance().display(mTopMovieItemIcon, movieInfo.getImages().getLarge());
            if(position == 0) {
                mRanking.setTextColor(mContext.getResources().getColor(R.color.material_orange_a700));
            } else if(position == 1){
                mRanking.setTextColor(mContext.getResources().getColor(R.color.material_orange_a200));

            } else if(position == 2) {
                mRanking.setTextColor(mContext.getResources().getColor(R.color.material_orange_a100));

            } else {
                mRanking.setTextColor(mContext.getResources().getColor(android.R.color.darker_gray));

            }

            mRanking.setText(position + 1 + "");

            final int[] x = new int[1];
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MovieDetailActivity.class);
                    int[] location = new int[2];
                    view.getLocationInWindow(location);
                    final int cy = location[1] + view.getHeight() / 2;

                    intent.putExtra("X", x[0]);
                    intent.putExtra("Y", cy);
                    intent.putExtra("ID", movieInfo.getId());
                    mContext.startActivity(intent);
                }
            });

            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    x[0] = (int) motionEvent.getX();
                    return false;
                }
            });
        }
    }


}
