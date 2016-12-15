package com.whyalwaysmea.bigboom.view.movielist.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
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
 * on 2016/9/9.
 */
public class InTheatersMovieAdapter extends BaseAdapter<MovieInfo> {


    public InTheatersMovieAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.in_theaters_movie_item, parent, false);
        return new InTheaterHolder(view);
    }


    class InTheaterHolder extends BaseViewHolder {

        @BindView(R.id.movie_item_photo)
        ImageView mMovieItemPhoto;
        @BindView(R.id.movie_item_name)
        TextView mMovieItemName;
        @BindView(R.id.ratingBar_hots)
        RatingBar mRatingBarHots;
        @BindView(R.id.top_movie_item_score)
        TextView mTopMovieItemScore;

        public InTheaterHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            MovieInfo movieInfo = mData.get(position);
            ImageUtils.getInstance().display(mMovieItemPhoto, movieInfo.getImages().getLarge());
            mMovieItemName.setText(movieInfo.getTitle());
            mTopMovieItemScore.setText("" + movieInfo.getRating().getAverage());
            mRatingBarHots.setRating((float) movieInfo.getRating().getAverage());

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
