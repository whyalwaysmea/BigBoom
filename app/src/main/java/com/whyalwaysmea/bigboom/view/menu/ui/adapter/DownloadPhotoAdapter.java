package com.whyalwaysmea.bigboom.view.menu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.DownloadPhoto;
import com.whyalwaysmea.bigboom.widget.RatioImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/30.
 */

public class DownloadPhotoAdapter extends BaseAdapter<DownloadPhoto> {

    private boolean isDel;
    private List<Integer> delPositions;

    public DownloadPhotoAdapter(Context context) {
        super(context);
        delPositions = new ArrayList<>();
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
            DownloadPhoto downloadPhoto = mData.get(position);
            mItemPhoto.setImageBitmap(downloadPhoto.getBitmap());
            if(isDel()) {
                mItemCheckbox.setVisibility(View.VISIBLE);
                mItemCheckbox.setChecked(downloadPhoto.isCheck());
                mItemCheckbox.setOnCheckedChangeListener((compoundButton, b) -> {
                    if(b) {
                        delPositions.add(position);
                    } else {
                        delPositions.remove(Integer.valueOf(position));
                    }
                });
                mItemPhoto.setOnClickListener(v -> mItemCheckbox.setChecked(!mItemCheckbox.isChecked()));
            } else {
                mItemCheckbox.setVisibility(View.GONE);
            }
        }
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    public List<Integer> getDelPositions() {
        return delPositions;
    }

    public void setDelPositions(List<Integer> delPositions) {
        this.delPositions = delPositions;
    }
}
