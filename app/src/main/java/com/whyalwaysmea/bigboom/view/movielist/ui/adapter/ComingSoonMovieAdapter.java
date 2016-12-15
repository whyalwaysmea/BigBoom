package com.whyalwaysmea.bigboom.view.movielist.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MovieDetailActivity;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/12.
 */
public class ComingSoonMovieAdapter extends BaseAdapter<MovieInfo> {


    public ComingSoonMovieAdapter(Context context, boolean useAnimation) {
        super(context, useAnimation);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.coming_soon_movie_item, parent, false);
        return new ComingSoonHolder(view);
    }

    class ComingSoonHolder extends BaseViewHolder {

        @BindView(R.id.coming_soon_movie_pic)
        ImageView mComingSoonMoviePic;
        @BindView(R.id.coming_soon_movie_name)
        TextView mComingSoonMovieName;
        @BindView(R.id.coming_soon_movie_type)
        TextView mComingSoonMovieType;
        @BindView(R.id.coming_soon_movie_performer)
        TextView mComingSoonMoviePerformer;
        @BindView(R.id.coming_soon_movie_directors)
        TextView mComingSoonMovieDirectors;


        public ComingSoonHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            MovieInfo movieInfo = mData.get(position);
            ImageUtils.getInstance().display(mComingSoonMoviePic, movieInfo.getImages().getLarge());
            mComingSoonMovieName.setText(movieInfo.getTitle());
            mComingSoonMovieType.setText("类别：" + movieInfo.getGenres().toString());
            StringBuffer sb = new StringBuffer();
            sb.append("主演：");
            for (int i = 0; i < movieInfo.getCasts().size(); i++) {
                if(i != movieInfo.getCasts().size() - 1) {
                    sb.append(movieInfo.getCasts().get(i).getName() + "/");
                } else {
                    sb.append(movieInfo.getCasts().get(i).getName());
                }
            }
            if(movieInfo.getCasts() != null && movieInfo.getCasts().size() >0) {
                mComingSoonMoviePerformer.setText(sb.toString());
            }

            if(movieInfo.getDirectors() != null && movieInfo.getDirectors().size() > 0) {
                mComingSoonMovieDirectors.setText("导演：" + movieInfo.getDirectors().get(0).getName());
            }

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
                    intent.putExtra("ID", movieInfo.getId());
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
