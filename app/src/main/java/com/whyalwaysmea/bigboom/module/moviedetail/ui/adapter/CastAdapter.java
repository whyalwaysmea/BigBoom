package com.whyalwaysmea.bigboom.module.moviedetail.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.utils.DensityUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/2.
 */

public class CastAdapter extends BaseAdapter<CastDetail.PhotosBean> {


    private int mRgb;

    public CastAdapter(Context context, List<CastDetail.PhotosBean> data) {
        super(context, data);
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
                params.height = DensityUtils.dp2px(mContext, 130);
                mPhoto.setLayoutParams(params);
                ImageUtils.getInstance().display(mPhoto, mData.get(position).getImage());
                allPhoto.setVisibility(View.GONE);
            } else {
                ImageUtils.getInstance().display(mPhoto, mData.get(position).getImage());
                allPhoto.setVisibility(View.GONE);
            }
        }
    }

    @SuppressLint("NewApi")
    private void colorChange(Bitmap bitmap) {
        // 用来提取颜色的Bitmap

        // Palette的部分
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            /**
             * 提取完之后的回调方法
             */
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                /* 界面颜色UI统一性处理,看起来更Material一些 */
                mRgb = vibrant.getRgb();
            }
        });
    }

    private int colorBurn(int RGBValues) {
        int alpha = RGBValues >> 24;
        int red = RGBValues >> 16 & 0xFF;
        int green = RGBValues >> 8 & 0xFF;
        int blue = RGBValues & 0xFF;
        red = (int) Math.floor(red * (1 - 0.1));
        green = (int) Math.floor(green * (1 - 0.1));
        blue = (int) Math.floor(blue * (1 - 0.1));
        return Color.rgb(red, green, blue);
    }
}
