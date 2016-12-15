package com.whyalwaysmea.bigboom.view.menu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;
import com.whyalwaysmea.bigboom.bean.db.HistoryBean;
import com.whyalwaysmea.bigboom.view.cast.ui.CastDetailActivity;
import com.whyalwaysmea.bigboom.view.menu.presenter.HistoryPresenterImp;
import com.whyalwaysmea.bigboom.view.menu.ui.adapter.HistoryAdapter;
import com.whyalwaysmea.bigboom.view.menu.view.IHistoryView;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.MovieDetailActivity;
import com.whyalwaysmea.bigboom.widget.GridMarginDecoration;
import com.whyalwaysmea.bigboom.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends MvpActivity<IHistoryView, HistoryPresenterImp> implements IHistoryView, SwipeRefreshLayout.OnRefreshListener {

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

        mSwiperefreshlayout.setOnRefreshListener(this);

    }

    @Override
    protected void initData() {
        mGridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerview.setLayoutManager(mGridLayoutManager);
        mHistoryBeanList = new ArrayList<>();
        mHistoryAdapter = new HistoryAdapter(this);
        mRecyclerview.setAdapter(mHistoryAdapter);
        mRecyclerview.addItemDecoration(new GridMarginDecoration(mContext.getResources().getDimensionPixelSize(R.dimen.gridlayout_margin_decoration)));

        mPresenter.getHistoryMovies();
        mPresenter.getHistoryCasts();

        mHistoryAdapter.setOnLongClickListener((view, position) -> {
            new AlertDialog.Builder(mContext)
                    .setMessage(R.string.del_browsing_history)
                    .setNegativeButton(R.string.cancle, (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setPositiveButton(R.string.confirm, (dialog, which) -> {
                        del(position);
                    })
                    .create()
                    .show();
        });

        mHistoryAdapter.setOnClickListener((view, position) -> {
            HistoryBean historyBean = null;
            if(mHistoryAdapter.getMovieSize() > 0 && position <= mHistoryAdapter.getMovieSize()) {
                historyBean = mHistoryBeanList.get(position - 1);
            }else if(mHistoryAdapter.getCastSize() > 0 && position > (mHistoryAdapter.getMovieSize() > 0 ? mHistoryAdapter.getMovieSize() + 1 : 0)) {
                historyBean = mHistoryBeanList.get(mHistoryAdapter.getMovieSize() > 0 ? position - 2 : position - 1);
            }
            if(historyBean != null && historyBean.getType() == Constants.TYPE.MOVIE) {
                Intent intent = new Intent(mContext, MovieDetailActivity.class);
                intent.putExtra("ID", historyBean.getHistoryId());
                startActivity(intent);
            } else if(historyBean != null && historyBean.getType() == Constants.TYPE.CAST) {
                Intent intent = new Intent(mContext, CastDetailActivity.class);
                intent.putExtra(Constants.KEY.CASTID, historyBean.getHistoryId());
                startActivity(intent);
            }
        });
    }

    private void del(int position) {
        HistoryBean historyBean = null;
        if(mHistoryAdapter.getMovieSize() > 0 && position <= mHistoryAdapter.getMovieSize()) {
            historyBean = mHistoryBeanList.get(position - 1);
        }else if(mHistoryAdapter.getCastSize() > 0 && position > (mHistoryAdapter.getMovieSize() > 0 ? mHistoryAdapter.getMovieSize() + 1 : 0)) {
            historyBean = mHistoryBeanList.get(mHistoryAdapter.getMovieSize() > 0 ? position - 2 : position - 1);
        }
        if(historyBean != null) {
            mPresenter.delHistory(historyBean);
        }
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
            mHistoryBeanList.add(new HistoryBean(dbMovie.getId(), dbMovie.getMovieId(), Constants.TYPE.MOVIE, dbMovie.getImgUrl()));
            mHistoryAdapter.addData(new HistoryBean(dbMovie.getId(), dbMovie.getMovieId(), Constants.TYPE.MOVIE, dbMovie.getImgUrl()));
        }

        mHistoryAdapter.setMovieSize(movies.size());
        mHistoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCasts(List<DBCast> casts) {
        for (int i = 0; i < casts.size(); i++) {
            DBCast cast = casts.get(i);
            mHistoryBeanList.add(new HistoryBean(cast.getId(), cast.getCastId(), Constants.TYPE.CAST, cast.getImgUrl()));
            mHistoryAdapter.addData(new HistoryBean(cast.getId(), cast.getCastId(), Constants.TYPE.CAST, cast.getImgUrl()));
        }

        mHistoryAdapter.setCastSize(casts.size());
        mHistoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void delHistorySuccess() {
        mHistoryBeanList.clear();
        mHistoryAdapter.clear();
        mHistoryAdapter.setCastSize(0);
        mHistoryAdapter.setMovieSize(0);
        mHistoryAdapter.notifyDataSetChanged();
        mPresenter.getHistoryMovies();
        mPresenter.getHistoryCasts();
    }

    @Override
    public void onRefresh() {
        mHistoryAdapter.clear();
        mHistoryBeanList.clear();
        mHistoryAdapter.notifyDataSetChanged();
        mPresenter.getHistoryMovies();
        mPresenter.getHistoryCasts();
    }
}
