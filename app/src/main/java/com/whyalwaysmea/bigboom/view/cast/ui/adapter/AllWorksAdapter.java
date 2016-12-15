package com.whyalwaysmea.bigboom.view.cast.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MovieDetailActivity;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/9.
 */

public class AllWorksAdapter extends BaseAdapter<CastWork.WorksBean> {

    public AllWorksAdapter(Context context, boolean useAnimation) {
        super(context, useAnimation);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_all_works, parent, false);
        return new AllWorksHolder(view);
    }

    class AllWorksHolder extends BaseViewHolder {

        @BindView(R.id.work_img)
        ImageView mWorkImg;
        @BindView(R.id.work_title)
        TextView mWorkTitle;
        @BindView(R.id.casts)
        TextView mCasts;
        @BindView(R.id.ratingBar_hots)
        AppCompatRatingBar mRatingBarHots;
        @BindView(R.id.wrok_rating)
        TextView mWrokRating;
        @BindView(R.id.roles)
        LinearLayout mRoles;

        public AllWorksHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            CastWork.WorksBean worksBean = mData.get(position);

            if(!worksBean.getSubject().getImages().getLarge().contains(".gif")) {
                ImageUtils.getInstance().display(mWorkImg, worksBean.getSubject().getImages().getLarge());
            } else {
                ImageUtils.getInstance().display(mWorkImg, R.drawable.no_img);
            }

            mWorkTitle.setText(worksBean.getSubject().getTitle() + " (" + worksBean.getSubject().getYear() + ")");
            if(!worksBean.getSubject().getCasts().isEmpty()) {
                StringBuffer sbCasts = new StringBuffer();
                for (int i = 0; i < worksBean.getSubject().getCasts().size(); i++) {
                    if(i == worksBean.getSubject().getCasts().size() - 1) {
                        sbCasts.append(worksBean.getSubject().getCasts().get(i).getName());
                    } else {
                        sbCasts.append(worksBean.getSubject().getCasts().get(i).getName() + "/");
                    }
                }
                mCasts.setText("演员：" + sbCasts.toString());
            }
            mRatingBarHots.setRating(worksBean.getSubject().getRating().getAverage());
            mWrokRating.setText("" + worksBean.getSubject().getRating().getAverage());
            mRoles.removeAllViews();
            for (int i = 0; i < worksBean.getRoles().size(); i++) {
                TextView tv = new TextView(mContext);
                tv.setText(worksBean.getRoles().get(i));
                tv.setPadding(10, 5, 10, 5);
                mRoles.addView(tv);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tv.getLayoutParams();
                layoutParams.setMargins(0, 10, 10, 10);
                tv.setLayoutParams(layoutParams);
                tv.setTextSize(12);
                tv.setBackgroundColor(mContext.getResources().getColor(R.color.material_black10));
            }

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, MovieDetailActivity.class);
                intent.putExtra("ID", worksBean.getSubject().getId());
                mContext.startActivity(intent);
            });
        }
    }
}
