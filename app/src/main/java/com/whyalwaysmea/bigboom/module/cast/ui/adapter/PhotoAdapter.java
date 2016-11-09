package com.whyalwaysmea.bigboom.module.cast.ui.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.CastPhoto;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.RatioImageView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/7.
 */

public class PhotoAdapter extends BaseAdapter<CastPhoto.PhotosBean> {

    private SparseArray<Integer> mSizeMode;

    public PhotoAdapter(Context context, List<CastPhoto.PhotosBean> data) {
        super(context, data);
        mSizeMode = new SparseArray<>();
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    class PhotoViewHolder extends BaseViewHolder {

        @BindView(R.id.item_photo)
        RatioImageView mItemPhoto;

        public PhotoViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            CastPhoto.PhotosBean photosBean = mData.get(position);
            mItemPhoto.setOriginalSize(photosBean.getWidth(), photosBean.getHeight());

            ImageUtils.getInstance().display(mItemPhoto, photosBean.getImage());

        }
    }


}
