package com.whyalwaysmea.bigboom.view.menu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.base.EmptyViewHolder;
import com.whyalwaysmea.bigboom.bean.db.HistoryBean;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.widget.RatioImageView;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/11/24.
 */

public class HistoryAdapter extends BaseAdapter<HistoryBean> {

    private int movieSize;
    private int castSize;
    private int TYPE_MOVIE_TITLE = 11;
    private int TYPE_CAST_TITLE = 22;

    public HistoryAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_MOVIE_TITLE) {
            View movieTitle = mLayoutInflater.inflate(R.layout.item_layout_movie_title, parent, false);
            return new EmptyViewHolder(movieTitle);
        } else if(viewType == TYPE_CAST_TITLE) {
            View castTitle = mLayoutInflater.inflate(R.layout.item_layout_cast_title, parent, false);
            return new EmptyViewHolder(castTitle);
        }
        View view = mLayoutInflater.inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if(getMovieSize() > 0 && position == 0) {
            return TYPE_MOVIE_TITLE;
        }
        if(getCastSize() > 0 && position == (getMovieSize() > 0 ? getMovieSize() + 1 : 0)) {
            return TYPE_CAST_TITLE;
        }
        return TYPE_DEFAULT;
    }

    @Override
    public int getItemCount() {
        int itemCount = super.getItemCount();
        if (getMovieSize() > 0) {
            itemCount++;
        }
        if (getCastSize() > 0) {
            itemCount++;
        }
        return itemCount;
    }

    class ViewHolder extends BaseViewHolder {

        @BindView(R.id.item_photo)
        RatioImageView mItemPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemPhoto.setOriginalSize(1);
        }

        @Override
        public void bindData(int position) {
            mItemPhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if(getMovieSize() > 0 && position <= getMovieSize()) {
                ImageUtils.getInstance().display(mItemPhoto, mData.get(position - 1).getImgUrl()) ;
            } else if(getCastSize() > 0 && position > (getMovieSize() > 0 ? getMovieSize() + 1 : 0)) {
                ImageUtils.getInstance().display(mItemPhoto, mData.get(getMovieSize() > 0 ? position - 2 : position - 1).getImgUrl());
            }
            mItemPhoto.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnLongClickListener.setOnLongItemClickListener(v, position);
                    return true;
                }
            });

            mItemPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.setOnItemClickListener(v, position);
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();

            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    if(viewType == TYPE_DEFAULT) {
                        return 1;
                    } else {
                        return gridLayoutManager.getSpanCount();
                    }
                }
            });
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public int getMovieSize() {
        return movieSize;
    }

    public void setMovieSize(int movieSize) {
        this.movieSize = movieSize;
    }

    public int getCastSize() {
        return castSize;
    }

    public void setCastSize(int castSize) {
        this.castSize = castSize;
    }
}
