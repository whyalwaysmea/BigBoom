package com.whyalwaysmea.bigboom.module.moviedetail.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.utils.DensityUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/17.
 */

public class MoviePhotoAdapter extends BaseAdapter<MovieDetail.PhotosBean> {

    public MoviePhotoAdapter(Context context, List<MovieDetail.PhotosBean> data) {
        super(context, data);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_photo_movie_detail, parent, false);
        return new MoviePhotoViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    class MoviePhotoViewHolder extends BaseViewHolder {

        @BindView(R.id.movie_item_photo)
        ImageView mMovieItemPhoto;
        @BindView(R.id.all_movie_photo)
        TextView mAllMoviePhoto;

        public MoviePhotoViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
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
        }
    }
}
