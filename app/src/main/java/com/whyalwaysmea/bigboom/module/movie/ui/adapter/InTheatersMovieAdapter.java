package com.whyalwaysmea.bigboom.module.movie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Long
 * on 2016/9/9.
 */
public class InTheatersMovieAdapter extends RecyclerView.Adapter<InTheatersMovieAdapter.InTheaterHolder> {

    private Context mContext;
    private List<MovieInfo> mMovieInfos;

    public InTheatersMovieAdapter(Context context, List<MovieInfo> movieInfo) {
        this.mContext = context;
        this.mMovieInfos = movieInfo;
    }


    @Override
    public InTheaterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.in_theaters_movice_item, parent, false);
        return new InTheaterHolder(view);
    }

    @Override
    public void onBindViewHolder(InTheaterHolder holder, int position) {
        MovieInfo movieInfo = mMovieInfos.get(position);

        ImageUtils.getInstance().display(holder.mMovieItemPhoto, movieInfo.getImages().getLarge());
        holder.mMovieItemName.setText(movieInfo.getTitle());
        holder.mTopMovieItemScore.setText("" + movieInfo.getRating().getAverage());
        holder.mRatingBarHots.setRating((float) movieInfo.getRating().getAverage());
    }

    @Override
    public int getItemCount() {
        return mMovieInfos.size();
    }

    class InTheaterHolder extends RecyclerView.ViewHolder {

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
            ButterKnife.bind(this, itemView);
        }

    }
}
