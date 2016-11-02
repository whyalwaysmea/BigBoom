package com.whyalwaysmea.bigboom.module.moviedetail.ui.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.socks.library.KLog;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/2.
 */

public class CastWorksAdapter extends BaseAdapter<CastWork.WorksBean> {


    public CastWorksAdapter(Context context, List<CastWork.WorksBean> data) {
        super(context, data);
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

            KLog.e("add data " + position);
        }
    }
}
