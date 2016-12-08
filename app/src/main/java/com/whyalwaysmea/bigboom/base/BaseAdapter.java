package com.whyalwaysmea.bigboom.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.whyalwaysmea.bigboom.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long
 * on 2016/9/12.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    protected static final int TYPE_EMPTY = 0;
    protected static final int TYPE_DEFAULT = 1;
    protected static int emptyLayout = R.layout.default_empty_layout;
    protected List<T> mData;
    protected Context mContext;
    protected boolean mUseAnimation;
    private int mLastPosition = -1;
    protected LayoutInflater mLayoutInflater;


    public BaseAdapter(Context context) {
        this.mContext = context;
        this.mData = new ArrayList<T>();
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public BaseAdapter(Context context, boolean useAnimation) {
        this.mContext = context;
        this.mData = new ArrayList<T>();
        this.mUseAnimation = useAnimation;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_EMPTY) {
            return onCreateEmptyViewHolder(parent, viewType);
        }
        return onCreateNormalViewHolder(parent, viewType);

    }

    protected BaseViewHolder onCreateEmptyViewHolder(ViewGroup parent, int viewType) {
        View emptyView = LayoutInflater.from(parent.getContext()).inflate(emptyLayout, parent, false);
        return new EmptyViewHolder(emptyView);
    }

    protected abstract BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(mUseAnimation) {
            setAnimation(holder.itemView, position);
        }
        if(mOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.setOnItemClickListener(v, position);
                }
            });
        }

        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mData == null || mData.isEmpty()) {
            return TYPE_EMPTY;
        } else {
            return TYPE_DEFAULT;
        }
    }

    public void setEmptyView(int emptyLayout) {
        this.emptyLayout = emptyLayout;
    }


    private void setAnimation(View view, int position) {
        if (position > mLastPosition) {
            Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.item_bottom_in);
            view.startAnimation(animation);
            mLastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        holder.itemView.clearAnimation();
    }

    public void addData(List<T> data) {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.addAll(data);
        notifyItemRangeInserted(getItemCount(), data.size());
    }

    public void addData(int pos, T item) {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(pos, item);
        notifyItemInserted(pos);
    }

    public void addData(T item) {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(item);
    }

    public List<T> getData() {
        return mData;
    }

    public void delete(int pos) {
        if(mData == null) {
            return ;
        }
        mData.remove(pos);
        notifyItemRemoved(pos);
    }

    public void clear() {
        if(mData != null) {
            mData.clear();
            notifyDataSetChanged();
        }
    }

    public interface OnClickListener {
        void setOnItemClickListener(View view, int position);
    }

    public interface OnLongClickListener {
        void setOnLongItemClickListener(View view, int position);
    }

    protected OnLongClickListener mOnLongClickListener;

    protected OnClickListener mOnClickListener;

    public OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public OnLongClickListener getOnLongClickListener() {
        return mOnLongClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        mOnLongClickListener = onLongClickListener;
    }
}
