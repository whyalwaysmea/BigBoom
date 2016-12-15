package com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.socks.library.KLog;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MoviePhotoActivity;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MoviePhotoListActivity;
import com.whyalwaysmea.bigboom.view.player.MoviePlayerActivity;
import com.whyalwaysmea.bigboom.utils.DensityUtils;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/17.
 */

public class MoviePhotoAdapter extends BaseAdapter<MovieDetail.PhotosBean> {

    private String movieId;
    private String videoURL;
    private MovieDetail movieDetail;

    public MoviePhotoAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_photo_movie_detail, parent, false);
        return new MoviePhotoViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if(TextUtils.isEmpty(getVideoURL())) {
            return super.getItemCount() + 1;
        } else {
            return super.getItemCount() + 2;
        }
    }

    class MoviePhotoViewHolder extends BaseViewHolder {

        @BindView(R.id.movie_item_photo)
        ImageView mMovieItemPhoto;
        @BindView(R.id.all_movie_photo)
        TextView mAllMoviePhoto;
        @BindView(R.id.movie_item_play)
        ImageView mMovieItemPlay;


        public MoviePhotoViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            if(TextUtils.isEmpty(getVideoURL())) {
                if (position == 0) {
                    itemView.setPadding(DensityUtils.dp2px(mContext, 24), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5));
                    mAllMoviePhoto.setVisibility(View.GONE);
                    ImageUtils.getInstance().display(mMovieItemPhoto, mData.get(position).getImage());
                } else if (position == getItemCount() - 1) {
                    mAllMoviePhoto.setVisibility(View.VISIBLE);
                    ImageUtils.getInstance().display(mMovieItemPhoto, R.drawable.white_bg);
                } else {
                    mAllMoviePhoto.setVisibility(View.GONE);
                    ImageUtils.getInstance().display(mMovieItemPhoto, mData.get(position).getImage());
                }

                if(position == getItemCount() - 1) {
                    itemView.setOnClickListener(v -> {
                        if(!TextUtils.isEmpty(getMovieId())) {
                            Intent intent = new Intent(mContext, MoviePhotoListActivity.class);
                            intent.putExtra(Constants.KEY.ID, getMovieId());
                            mContext.startActivity(intent);
                        }

                    });
                } else {
                    itemView.setOnClickListener(v -> {
                        if(!TextUtils.isEmpty(getMovieId())) {
                            Intent intent = new Intent(mContext, MoviePhotoActivity.class);
                            intent.putExtra(Constants.KEY.ID, getMovieId());
                            intent.putExtra(Constants.KEY.POSITION, position);
                            mContext.startActivity(intent);
                        }
                    });
                }
            } else {
                if (position == 0) {
                    itemView.setPadding(DensityUtils.dp2px(mContext, 24), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5));
                    ImageUtils.getInstance().display(mMovieItemPhoto, getVideoURL());
                    KLog.e(".." + getVideoURL());

                    mAllMoviePhoto.setVisibility(View.GONE);
                    mMovieItemPlay.setVisibility(View.VISIBLE);
                } else if (position == getItemCount() - 1) {
                    mMovieItemPlay.setVisibility(View.GONE);
                    mAllMoviePhoto.setVisibility(View.VISIBLE);
                    ImageUtils.getInstance().display(mMovieItemPhoto, R.drawable.white_bg);
                } else {
                    mMovieItemPlay.setVisibility(View.GONE);
                    mAllMoviePhoto.setVisibility(View.GONE);
                    ImageUtils.getInstance().display(mMovieItemPhoto, mData.get(position - 1).getImage());
                }

                itemView.setOnClickListener(v -> {
                    if (position == 0) {
                        Intent intent = new Intent(mContext, MoviePlayerActivity.class);
                        intent.putExtra(Constants.KEY.MOVIE_URLS, getMovieDetail());
                        mContext.startActivity(intent);
                    } else if (position == getItemCount() - 1) {
                        Intent intent = new Intent(mContext, MoviePhotoListActivity.class);
                        intent.putExtra(Constants.KEY.ID, getMovieId());
                        mContext.startActivity(intent);
                    } else {
                        Intent intent = new Intent(mContext, MoviePhotoActivity.class);
                        intent.putExtra(Constants.KEY.ID, getMovieId());
                        intent.putExtra(Constants.KEY.POSITION, position);
                        mContext.startActivity(intent);
                    }
                });
            }
        }
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public MovieDetail getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }
}
