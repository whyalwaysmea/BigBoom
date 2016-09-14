package com.whyalwaysmea.bigboom.module.movie.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/9/12.
 */
public class ComingSoonMovieAdapter extends BaseAdapter<MovieInfo> {




    public ComingSoonMovieAdapter(Context context, List<MovieInfo> data, boolean useAnimation) {
        super(context, data, useAnimation);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.coming_soon_movie_item, parent, false);
        return new ComingSoonHolder(view);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        if(holder instanceof ComingSoonHolder) {
            MovieInfo movieInfo = mData.get(position);
            ComingSoonHolder comingSoonHolder = (ComingSoonHolder) holder;
            ImageUtils.getInstance().display(comingSoonHolder.mComingSoonMoviePic, movieInfo.getImages().getLarge());
            comingSoonHolder.mComingSoonMovieName.setText(movieInfo.getTitle());
            comingSoonHolder.mComingSoonMovieType.setText("类别：" + movieInfo.getGenres().toString());
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
                comingSoonHolder.mComingSoonMoviePerformer.setText(sb.toString());
            }

            if(movieInfo.getDirectors() != null && movieInfo.getDirectors().size() > 0) {
                comingSoonHolder.mComingSoonMovieDirectors.setText("导演：" + movieInfo.getDirectors().get(0).getName());
            }
        }
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
    }

}
