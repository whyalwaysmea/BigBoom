package com.whyalwaysmea.bigboom.view.menu.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.DownloadPhoto;
import com.whyalwaysmea.bigboom.view.menu.presenter.DownloadManagerPresenterImp;
import com.whyalwaysmea.bigboom.view.menu.ui.adapter.DownloadPhotoAdapter;
import com.whyalwaysmea.bigboom.view.menu.view.IDownloadManagerView;
import com.whyalwaysmea.bigboom.widget.GridMarginDecoration;

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
        mDownloadPhotoAdapter = new DownloadPhotoAdapter(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.download_manager_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.download_manager_del) {
            if(mDownloadPhotoAdapter.isDel() && mDownloadPhotoAdapter.getDelPositions().size() > 0) {
                new AlertDialog.Builder(mContext)
                        .setMessage(R.string.del_download_photo)
                        .setNegativeButton(R.string.cancle, (dialog, which) -> {
                            dialog.dismiss();
                        })
                        .setPositiveButton(R.string.confirm, (dialog, which) -> {
                            mPresenter.delDownloadPhotos(mDownloadPhotoAdapter.getDelPositions(), mDownloadPhotoAdapter.getData());
                        })
                        .create()
                        .show();
            } else if(mDownloadPhotoAdapter.isDel() && mDownloadPhotoAdapter.getDelPositions().size() == 0) {
                mDownloadPhotoAdapter.setDel(false);
                mDownloadPhotoAdapter.notifyDataSetChanged();
            } else {
                mDownloadPhotoAdapter.setDel(true);
                mDownloadPhotoAdapter.notifyDataSetChanged();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showDownloadPhotos(List<DownloadPhoto> bitmaps) {
        mDownloadPhotoAdapter.addData(bitmaps);
        mDownloadPhotoAdapter.notifyDataSetChanged();
    }

    @Override
    public void delDownloadPhotos() {
        mDownloadPhotoAdapter.clear();
        mDownloadPhotoAdapter.notifyDataSetChanged();
        mDownloadPhotoAdapter.setDel(false);
        mPresenter.getDownloadPhotos(this);
    }
}
