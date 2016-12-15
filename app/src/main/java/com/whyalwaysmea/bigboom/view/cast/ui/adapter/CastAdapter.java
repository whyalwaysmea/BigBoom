package com.whyalwaysmea.bigboom.view.cast.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.cast.ui.PhotoActivity;
import com.whyalwaysmea.bigboom.view.cast.ui.PhotoListActivity;
import com.whyalwaysmea.bigboom.utils.DensityUtils;

import java.io.Serializable;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/2.
 */

public class CastAdapter extends BaseAdapter<CastDetail.PhotosBean> {

    private String castId;
    private String castName;

    public CastAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_cast2, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    class CastViewHolder extends BaseViewHolder {

        @BindView(R.id.photo)
        ImageView mPhoto;

        @BindView(R.id.all_photo)
        TextView allPhoto;

        public CastViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            if(position == 0) {
                ViewGroup.LayoutParams params = mPhoto.getLayoutParams();
                params.width = DensityUtils.dp2px(mContext, 160);
                params.height = DensityUtils.dp2px(mContext, 265);
                mPhoto.setLayoutParams(params);
                ImageUtils.getInstance().display(mPhoto, mData.get(position).getImage());
                allPhoto.setVisibility(View.GONE);
//                GlideBitmapDrawable imageDrawable = (GlideBitmapDrawable) mPhoto.getDrawable();
//                colorChange(imageDrawable.getBitmap());

            } else if(position == getItemCount() - 1) {
                allPhoto.setVisibility(View.VISIBLE);

                mPhoto.setBackground(mContext.getResources().getDrawable(R.drawable.border_bg));
            } else if(position == getItemCount() - 2){
                ViewGroup.LayoutParams params = mPhoto.getLayoutParams();
                params.width = DensityUtils.dp2px(mContext, 130);
                params.height = DensityUtils.dp2px(mContext, 125);
                mPhoto.setLayoutParams(params);
                ImageUtils.getInstance().display(mPhoto, mData.get(position).getImage());
                allPhoto.setVisibility(View.GONE);
            } else {
                ImageUtils.getInstance().display(mPhoto, mData.get(position).getImage());
                allPhoto.setVisibility(View.GONE);
            }

            if(position == getItemCount() - 1 && !TextUtils.isEmpty(castId)
                    && !TextUtils.isEmpty(castName)) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, PhotoListActivity.class);
                        intent.putExtra(Constants.KEY.CASTID, castId);
                        intent.putExtra(Constants.KEY.CAST_NAME, castName);
                        mContext.startActivity(intent);
                    }
                });
            } else {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, PhotoActivity.class);
                        intent.putExtra(Constants.KEY.PHOTOT_URL, (Serializable) mData);
                        intent.putExtra(Constants.KEY.POSITION, position);
                        intent.putExtra(Constants.KEY.CASTID, castId);
                        intent.putExtra(Constants.KEY.CAST_NAME, castName);

                        mContext.startActivity(intent);
                    }
                });
            }
        }
    }


    public String getCastId() {
        return castId;
    }

    public void setCastId(String castId) {
        this.castId = castId;
    }

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }
}
