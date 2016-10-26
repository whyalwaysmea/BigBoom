package com.whyalwaysmea.bigboom.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.utils.MeasureUtil;

/**
 * Created by Long
 * on 2016/9/23.
 */

public class SearchView {

    private Context mContext;
    private ImageView mSearchBack;
    private ImageView mSearchClear;
    private ImageView mSearchSure;
    private EditText mSearchInput;
    private OnSearchClickListener mOnSearchClickListener;

    private View showAtView;

    public SearchView(Context context, View view, OnSearchClickListener onSearchClickListener) {
        this.mContext = context;
        this.mOnSearchClickListener = onSearchClickListener;
        this.showAtView = view;
        initView();
        initEvent();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_view, null);
        mSearchBack = (ImageView) view.findViewById(R.id.search_back);
        mSearchClear = (ImageView) view.findViewById(R.id.search_clear);
        mSearchSure = (ImageView) view.findViewById(R.id.search_sure);
        mSearchInput = (EditText) view.findViewById(R.id.search_input);

        PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(showAtView, Gravity.NO_GRAVITY, 0, MeasureUtil.getStatusBarHeight(mContext));

    }

    private void initEvent() {
        RxView.clicks(mSearchBack).subscribe(aVoid -> mOnSearchClickListener.closeSearchView());
        RxView.clicks(mSearchClear).subscribe(aVoid -> mSearchInput.setText(""));
        RxView.clicks(mSearchSure).subscribe();
        RxTextView.textChanges(mSearchInput).subscribe(this::OntextChanges);

    }

    public interface OnSearchClickListener {
        void closeSearchView();
        void searchInput(String s);
    }

    private void OnSearch() {
        if(mOnSearchClickListener != null && mSearchInput.length() > 0) {
            String s = mSearchInput.getText().toString().trim();
            mOnSearchClickListener.searchInput(s);
        } else {

        }
    }

    private void OntextChanges(CharSequence s) {
        if(s.length() > 0) {
            mSearchClear.setVisibility(View.VISIBLE);
        } else {
            mSearchClear.setVisibility(View.GONE);
        }
    }
}
