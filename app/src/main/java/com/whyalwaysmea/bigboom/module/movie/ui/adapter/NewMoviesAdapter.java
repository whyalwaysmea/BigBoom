package com.whyalwaysmea.bigboom.module.movie.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieInfo;

import java.util.List;

/**
 * Created by Long
 * on 2016/9/15.
 */
public class NewMoviesAdapter extends BaseAdapter<MovieInfo> {
    public NewMoviesAdapter(Context context, List<MovieInfo> data, boolean useAnimation) {
        super(context, data, useAnimation);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {

    }
}
