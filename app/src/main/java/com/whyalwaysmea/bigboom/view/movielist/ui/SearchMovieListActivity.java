package com.whyalwaysmea.bigboom.view.movielist.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.di.component.DaggerMovieListComponent;
import com.whyalwaysmea.bigboom.di.module.MovieListModule;
import com.whyalwaysmea.bigboom.view.movielist.presenter.MovieListPresenterImp;
import com.whyalwaysmea.bigboom.view.movielist.ui.adapter.ComingSoonMovieAdapter;
import com.whyalwaysmea.bigboom.view.movielist.view.IMovieListView;
import com.whyalwaysmea.bigboom.utils.SPUtils;
import com.whyalwaysmea.bigboom.utils.StatusBarUtil;
import com.whyalwaysmea.bigboom.widget.MyRecyclerView;
import com.whyalwaysmea.bigboom.widget.SearchView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchMovieListActivity extends MvpActivity<IMovieListView, MovieListPresenterImp> implements IMovieListView, MyRecyclerView.OnLoadMoreListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_movie_list)
    MyRecyclerView mSearchMovieList;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;

    private LinearLayoutManager mLinearLayoutManager;
    private ComingSoonMovieAdapter mComingSoonMovieAdapter;
    private int start;
    private String mSearchKey;

    @Inject
    MovieListPresenterImp mPresenter;

    @Override
    protected MovieListPresenterImp createPresenter(BaseView view) {
        DaggerMovieListComponent.builder()
                .movieListModule(new MovieListModule(this))
                .build()
                .inject(this);
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie_list);
        SPUtils spUtils = new SPUtils(this, Constants.SP.SHARED_PREFERENCES_NAME);

        if(spUtils.getBoolean(Constants.SP.THEME)) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            StatusBarUtil.setColor(this, getResources().getColor(R.color.primary_night), 0);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
        }
        ButterKnife.bind(this);

        init();
    }

    @Override
    protected void initView() {
        mLinearLayoutManager = new LinearLayoutManager(this);
        mSearchMovieList.setLayoutManager(mLinearLayoutManager);
        mComingSoonMovieAdapter = new ComingSoonMovieAdapter(this, true);
        mSearchMovieList.setAdapter(mComingSoonMovieAdapter);
        mSearchMovieList.setOnLoadMoreListener(this);

        mToolbar.setNavigationIcon(R.drawable.icon_back);
        mToolbar.setTitle(R.string.searching);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initData() {
        mSearchKey = getIntent().getStringExtra(Constants.KEY.SEARCH_KEY);
        mPresenter.getSearchMovieList(start, mSearchKey);

    }


    @Override
    public void setData(MovieListResponse movieListResponse) {
        mComingSoonMovieAdapter.addData(movieListResponse.getSubjects());
        if((start + movieListResponse.getCount()) < movieListResponse.getTotal()) {
            mSearchMovieList.enableLoadMore();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(false));
        mToolbar.setTitle(mSearchKey);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(true));
    }

    @Override
    public void onLoadMore() {
        start += 20;
        mPresenter.getSearchMovieList(start, mSearchKey);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_search) {
            showSearch();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSearch() {
        SearchView searchView = new SearchView(mContext, mToolbar, new SearchView.OnSearchClickListener() {

            @Override
            public void searchInput(String s) {
                mSearchKey = s.toString();
                start = 0;
                mPresenter.getSearchMovieList(start, mSearchKey);
            }
        });

    }
}
