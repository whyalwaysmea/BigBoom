package com.whyalwaysmea.bigboom.view.player.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieVideo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/15.
 */

public class MovieVideoAdapter extends BaseAdapter<MovieVideo> {

    private int playingPosition;

    public MovieVideoAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_movie_video, parent, false);
        return new MovieVideoHolder(view);
    }


    class MovieVideoHolder extends BaseViewHolder {

        @BindView(R.id.item_movie_video_img)
        ImageView mItemMovieVideoImg;
        @BindView(R.id.item_movie_video_name)
        TextView mItemMovieVideoName;
        @BindView(R.id.playing_bg)
        ImageView playingBg;

        public MovieVideoHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            MovieVideo movieVideo = mData.get(position);
            ImageUtils.getInstance().display(mItemMovieVideoImg, movieVideo.getImg());
            mItemMovieVideoName.setText(movieVideo.getTitle());
            if(position == getPlayingPosition()) {
                playingBg.setVisibility(View.VISIBLE);
            } else {
                playingBg.setVisibility(View.GONE);
            }
        }
    }

    public int getPlayingPosition() {
        return playingPosition;
    }

    public void setPlayingPosition(int playingPosition) {
        this.playingPosition = playingPosition;
    }
}
