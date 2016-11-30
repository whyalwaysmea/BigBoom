package com.whyalwaysmea.bigboom.module.menu.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.view.RatioImageView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/30.
 */

public class DownloadPhotoAdapter extends BaseAdapter<Bitmap> {

    private boolean isDel;

    public DownloadPhotoAdapter(Context context, List<Bitmap> data) {
        super(context, data);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_download_photo, parent, false);
        return new DownloadPhotoHolder(view);
    }

    class DownloadPhotoHolder extends BaseViewHolder {

        @BindView(R.id.item_photo)
        RatioImageView mItemPhoto;

        @BindView(R.id.item_checkbox)
        AppCompatCheckBox mItemCheckbox;

        public DownloadPhotoHolder(View itemView) {
            super(itemView);
            mItemPhoto.setOriginalSize(1);
        }

        @Override
        public void bindData(int position) {
            mItemPhoto.setImageBitmap(mData.get(position));
            if(isDel()) {
                mItemCheckbox.setVisibility(View.VISIBLE);
                mItemPhoto.setOnClickListener(v -> mItemCheckbox.setChecked(!mItemCheckbox.isChecked()));
            }
        }
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }
}
