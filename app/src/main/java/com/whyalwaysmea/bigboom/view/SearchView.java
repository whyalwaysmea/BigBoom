package com.whyalwaysmea.bigboom.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.whyalwaysmea.bigboom.R;

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

    public SearchView(Context context, OnSearchClickListener onSearchClickListener) {
        this.mContext = context;
        this.mOnSearchClickListener = onSearchClickListener;
        initView();
        initEvent();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_view, null);
        mSearchBack = (ImageView) view.findViewById(R.id.search_back);
        mSearchClear = (ImageView) view.findViewById(R.id.search_clear);
        mSearchSure = (ImageView) view.findViewById(R.id.search_sure);
        mSearchInput = (EditText) view.findViewById(R.id.search_input);
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
