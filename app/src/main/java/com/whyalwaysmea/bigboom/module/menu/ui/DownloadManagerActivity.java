package com.whyalwaysmea.bigboom.module.menu.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.module.menu.presenter.DownloadManagerPresenterImp;
import com.whyalwaysmea.bigboom.module.menu.ui.adapter.DownloadPhotoAdapter;
import com.whyalwaysmea.bigboom.module.menu.view.IDownloadManagerView;
import com.whyalwaysmea.bigboom.view.GridMarginDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DownloadManagerActivity extends MvpActivity<IDownloadManagerView, DownloadManagerPresenterImp> implements IDownloadManagerView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.download_recyclerview)
    RecyclerView mDownloadRecyclerview;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;

    private DownloadPhotoAdapter mDownloadPhotoAdapter;
    private List<Bitmap> mBitmaps;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager);
        ButterKnife.bind(this);

        init();
    }

    @Override
    protected void initView() {
        mBitmaps = new ArrayList<>();
        mDownloadPhotoAdapter = new DownloadPhotoAdapter(this, mBitmaps);
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mDownloadRecyclerview.addItemDecoration(new GridMarginDecoration(getResources().getDimensionPixelSize(R.dimen.gridlayout_margin_decoration2)));
        mDownloadRecyclerview.setLayoutManager(mGridLayoutManager);
        mDownloadRecyclerview.setAdapter(mDownloadPhotoAdapter);

        mToolbar.setTitle(R.string.download_manager);
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(v -> finish());

    }

    @Override
    protected void initData() {
        mPresenter.getDownloadPhotos(this);
    }

    @Override
    protected DownloadManagerPresenterImp createPresenter(BaseView view) {
        return new DownloadManagerPresenterImp(this);
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
    public void showDownloadPhotos(List<Bitmap> bitmaps) {
        mBitmaps.addAll(bitmaps);
        mDownloadPhotoAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.download_manager_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.download_manager_del) {
            mDownloadPhotoAdapter.setDel(true);
            mDownloadPhotoAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
