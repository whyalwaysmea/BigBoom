package com.whyalwaysmea.bigboom.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whyalwaysmea.bigboom.MainActivity;
import com.whyalwaysmea.bigboom.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Long
 * on 2016/9/2.
 */
public class MovieFragment extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static MovieFragment newInstance() {

        Bundle args = new Bundle();

        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).setToolbar(mToolbar);

    }
}
