package com.whyalwaysmea.bigboom.view.menu.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GithubActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView mWebview;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;

    private String url = "https://github.com/whyalwaysmea";
//    private String url = "http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        mToolbar.setTitle(R.string.whyalwaysmea);
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(view -> finish());
        mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(true));
    }

    @Override
    protected void initData() {
        mWebview.loadUrl(url);
        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mSwiperefreshlayout.post(() -> mSwiperefreshlayout.setRefreshing(false));
                mSwiperefreshlayout.setEnabled(false);
                super.onPageFinished(view, url);
            }
        });

    }
}
