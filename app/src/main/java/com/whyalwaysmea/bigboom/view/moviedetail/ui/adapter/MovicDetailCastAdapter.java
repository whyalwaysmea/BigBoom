package com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.cast.ui.CastDetailActivity;
import com.whyalwaysmea.bigboom.utils.DensityUtils;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/17.
 */

public class MovicDetailCastAdapter extends BaseAdapter<MovieDetail.CastsBean> {


    public MovicDetailCastAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cast, parent, false);
        return new CastHolder(view);
    }


    class CastHolder extends BaseViewHolder {

        @BindView(R.id.cast_item_avatar)
        ImageView mCastItemAvatar;
        @BindView(R.id.cast_item_name)
        TextView mCastItemName;
        @BindView(R.id.director)
        TextView mDirector;


        public CastHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            if(position == 0) {
                itemView.setPadding(DensityUtils.dp2px(mContext, 24), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5));
                mDirector.setVisibility(View.VISIBLE);
            } else {
                mDirector.setVisibility(View.GONE);
            }
            ImageUtils.getInstance().display(mCastItemAvatar, mData.get(position).getAvatars().getMedium());
            mCastItemName.setText(mData.get(position).getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, CastDetailActivity.class);
                    intent.putExtra(Constants.KEY.CASTID, mData.get(position).getId());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
