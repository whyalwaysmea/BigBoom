package com.whyalwaysmea.bigboom.module.menu.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.socks.library.KLog;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;
import com.whyalwaysmea.bigboom.bean.db.HistoryBean;
import com.whyalwaysmea.bigboom.module.menu.presenter.HistoryPresenterImp;
import com.whyalwaysmea.bigboom.module.menu.ui.adapter.HistoryAdapter;
import com.whyalwaysmea.bigboom.module.menu.view.IHistoryView;
import com.whyalwaysmea.bigboom.view.GridMarginDecoration;
import com.whyalwaysmea.bigboom.view.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends MvpActivity<IHistoryView, HistoryPresenterImp> implements IHistoryView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerview)
    MyRecyclerView mRecyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;

    private GridLayoutManager mGridLayoutManager;
    private HistoryAdapter mHistoryAdapter;
    private List<HistoryBean> mHistoryBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        init();
    }

    @Override
    protected void initView() {
        mToolbar.setTitle(R.string.browsing_history);
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(v -> finish());


    }

    @Override
    protected void initData() {
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerview.setLayoutManager(mGridLayoutManager);
        mHistoryBeanList = new ArrayList<>();
        mHistoryAdapter = new HistoryAdapter(this, mHistoryBeanList);
        mRecyclerview.setAdapter(mHistoryAdapter);
        mRecyclerview.addItemDecoration(new GridMarginDecoration(mContext.getResources().getDimensionPixelSize(R.dimen.gridlayout_margin_decoration)));

        mPresenter.getHistoryMovies(0);
        mPresenter.getHistoryCasts(0);
    }

    @Override
    protected HistoryPresenterImp createPresenter(BaseView view) {
        return new HistoryPresenterImp(this);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(true));
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(false));
    }

    @Override
    public void showMovies(List<DBMovie> movies) {
        for (int i = 0; i < movies.size(); i++) {
            DBMovie dbMovie = movies.get(i);
            mHistoryBeanList.add(new HistoryBean(dbMovie.getId(), dbMovie.getMovieId(), 1, dbMovie.getImgUrl()));
        }
        KLog.e("movies === " + movies.size());
        mHistoryAdapter.setMovieSize(movies.size());
        mHistoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCasts(List<DBCast> casts) {
        for (int i = 0; i < casts.size(); i++) {
            DBCast cast = casts.get(i);
            mHistoryBeanList.add(new HistoryBean(cast.getId(), cast.getCastId(), 2, cast.getImgUrl()));
        }
        KLog.e("casts === " + casts.size());
        mHistoryAdapter.setCastSize(casts.size());
        mHistoryAdapter.notifyDataSetChanged();
    }
}
