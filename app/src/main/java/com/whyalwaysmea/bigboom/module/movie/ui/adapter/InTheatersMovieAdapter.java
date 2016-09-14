package com.whyalwaysmea.bigboom.module.movie.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
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

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/9.
 */
public class InTheatersMovieAdapter extends BaseAdapter<MovieInfo> {


    public InTheatersMovieAdapter(Context context, List<MovieInfo> data) {
        super(context, data);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.in_theaters_movie_item, parent, false);
        return new InTheaterHolder(view);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        if(holder instanceof InTheaterHolder) {
            MovieInfo movieInfo = mData.get(position);
            InTheaterHolder inTheaterHolder = (InTheaterHolder) holder;
            ImageUtils.getInstance().display(inTheaterHolder.mMovieItemPhoto, movieInfo.getImages().getLarge());
            inTheaterHolder.mMovieItemName.setText(movieInfo.getTitle());
            inTheaterHolder.mTopMovieItemScore.setText("" + movieInfo.getRating().getAverage());
            inTheaterHolder.mRatingBarHots.setRating((float) movieInfo.getRating().getAverage());
        }
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

    }
}
