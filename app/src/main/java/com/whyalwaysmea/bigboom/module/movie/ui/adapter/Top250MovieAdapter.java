package com.whyalwaysmea.bigboom.module.movie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Long
 * on 2016/9/6.
 */
public class Top250MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<MovieInfo> mData;
    private int lastPosition = -1;

    public Top250MovieAdapter(Context context, List<MovieInfo> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.top_movie_item, parent, false);
        return new HotMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HotMovieHolder) {
            HotMovieHolder hotMovieHolder = (HotMovieHolder) holder;
            MovieInfo movieInfo = mData.get(position);

            hotMovieHolder.mTopMovieItemName.setText(movieInfo.getTitle());
            hotMovieHolder.mTopMovieItemOriginalName.setText(movieInfo.getOriginal_title());
            hotMovieHolder.mTopMovieItemDate.setText(mContext.getResources().getString(R.string.start_data) + movieInfo.getYear());
            hotMovieHolder.mRatingBarHots.setRating((float) movieInfo.getRating().getAverage() / 2);
            hotMovieHolder.mTopMovieItemScore.setText("" + movieInfo.getRating().getAverage());
            ImageUtils.getInstance().display(hotMovieHolder.mTopMovieItemIcon, movieInfo.getImages().getLarge());

            setAnimation(holder.itemView, position);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HotMovieHolder extends RecyclerView.ViewHolder {

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

        public HotMovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void setAnimation(View view, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.item_bottom_in);
            view.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        holder.itemView.clearAnimation();
    }
}
