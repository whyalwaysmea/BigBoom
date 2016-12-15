package com.whyalwaysmea.bigboom.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by Long
 * on 2016/9/8.
 */
public class MyRecyclerView extends RecyclerView {

    private int lastVisibleItemPosition;
    private int addItemCount;
    private OnLoadMoreListener mOnLoadMoreListener;

    private boolean isLoadMoreEnabled = true;


    public MyRecyclerView(Context context) {
        super(context);
        initView();
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();

    }

    private void initView() {
        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                /**
                 * SCROLL_STATE_IDLE  --> 表示已经停止滑动了
                 * SCROLL_STATE_FLING --> 表示手已经离开屏幕，靠惯性滑动
                 * SCROLL_STATE_TOUCH_SCROLL  --> 表示在用手滑动
                 */

                if(newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + addItemCount >= recyclerView.getAdapter().getItemCount()
                        && isLoadMoreEnabled) {
                    if(mOnLoadMoreListener != null) {
                        mOnLoadMoreListener.onLoadMore();
                        isLoadMoreEnabled = false;
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    addItemCount = 1;
                } else if(recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    lastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                    addItemCount = 1;
                } else {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                    int[] position = null;
                    int[] lastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(position);
                    lastVisibleItemPosition = lastVisibleItemPositions[0];
                    addItemCount = lastVisibleItemPositions.length + 1;
                }
            }
        });
    }


    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        mOnLoadMoreListener = onLoadMoreListener;
    }

    public void enableLoadMore() {
        isLoadMoreEnabled = true;
    }
}
