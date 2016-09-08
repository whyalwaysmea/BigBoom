package com.whyalwaysmea.bigboom.module.movie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Long
 * on 2016/9/6.
 */
public class HotMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<String> mData;
    private int lastPosition = -1;

    public HotMovieAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hot_movie_item, parent, false);
        return new HotMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HotMovieHolder) {
            HotMovieHolder hotMovieHolder = (HotMovieHolder) holder;
            hotMovieHolder.mMovieName.setText(mData.get(position));
            setAnimation(holder.itemView, position);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HotMovieHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_name)
        TextView mMovieName;

        public HotMovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void setAnimation(View view, int position) {
        if(position > lastPosition) {
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
