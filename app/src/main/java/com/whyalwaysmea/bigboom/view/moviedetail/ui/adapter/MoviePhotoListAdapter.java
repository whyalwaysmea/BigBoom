package com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MoviePhoto;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.widget.RatioImageView;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/11.
 */

public class MoviePhotoListAdapter extends BaseAdapter<MoviePhoto.PhotosBean> {


    public MoviePhotoListAdapter(Context context, boolean useAnimation) {
        super(context, useAnimation);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_photo, parent, false);
        return new MoviePhotoViewHolder(view);
    }

    class MoviePhotoViewHolder extends BaseViewHolder {

        @BindView(R.id.item_photo)
        RatioImageView mItemPhoto;

        public MoviePhotoViewHolder(View itemView) {
            super(itemView);
            mItemPhoto.setOriginalSize(1,1);
        }

        @Override
        public void bindData(int position) {
            mItemPhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
            MoviePhoto.PhotosBean photosBean = mData.get(position);
            ImageUtils.getInstance().display(mItemPhoto, photosBean.getImage());
        }
    }
}
