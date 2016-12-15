package com.whyalwaysmea.bigboom.view.cast.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MovieDetailActivity;
import com.whyalwaysmea.bigboom.utils.DensityUtils;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/2.
 */

public class CastWorksAdapter extends BaseAdapter<CastWork.WorksBean> {

    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;

    public CastWorksAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_cast_work, parent, false);
        return new CastWorksViewHolder(view);
    }

    class CastWorksViewHolder extends BaseViewHolder {

        @BindView(R.id.movie_item_photo)
        ImageView mMovieItemPhoto;
        @BindView(R.id.movie_item_name)
        TextView mMovieItemName;
        @BindView(R.id.ratingBar_hots)
        AppCompatRatingBar mRatingBarHots;
        @BindView(R.id.top_movie_item_score)
        TextView mTopMovieItemScore;
        @BindView(R.id.year)
        TextView mMovieYear;

        public CastWorksViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            CastWork.WorksBean worksBean = mData.get(position);

            ImageUtils.getInstance().display(mMovieItemPhoto, worksBean.getSubject().getImages().getLarge());
            mMovieItemName.setText(worksBean.getSubject().getTitle());
            mRatingBarHots.setRating(worksBean.getSubject().getRating().getAverage());
            mTopMovieItemScore.setText(worksBean.getSubject().getRating().getAverage() + "");
            mMovieYear.setText(worksBean.getSubject().getYear() + "");
            if(position == 0) {
                mMovieYear.setPadding(DensityUtils.dp2px(mContext, 10), 0 , DensityUtils.dp2px(mContext, 10), 0);
                mMovieYear.setVisibility(View.VISIBLE);
                itemView.setTag(FIRST_STICKY_VIEW);
            } else {
                CastWork.WorksBean oldWorksBean = mData.get(position - 1);
                if(oldWorksBean.getSubject().getYear().equals(worksBean.getSubject().getYear())) {
                    mMovieYear.setVisibility(View.GONE);
                    itemView.setTag(NONE_STICKY_VIEW);
                } else {
                    mMovieYear.setPadding(DensityUtils.dp2px(mContext, 10), 0 , DensityUtils.dp2px(mContext, 10), 0);
                    mMovieYear.setVisibility(View.VISIBLE);
                    itemView.setTag(HAS_STICKY_VIEW);
                }
            }
            itemView.setContentDescription("" + worksBean.getSubject().getYear());

            final int[] x = new int[1];
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MovieDetailActivity.class);
                    int[] location = new int[2];
                    view.getLocationInWindow(location);
                    final int cy = location[1] + view.getHeight() / 2;

                    intent.putExtra("X", x[0]);
                    intent.putExtra("Y", cy);
                    intent.putExtra("ID", worksBean.getSubject().getId());
                    mContext.startActivity(intent);
                }
            });

            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    x[0] = (int) motionEvent.getX();
                    return false;
                }
            });
        }
    }
}
