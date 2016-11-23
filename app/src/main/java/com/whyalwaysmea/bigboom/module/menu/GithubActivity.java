package com.whyalwaysmea.bigboom.module.menu;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GithubActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.webview)
    WebView mWebview;

//    private String url = "https://github.com/whyalwaysmea";
    private String url = "https://www.baidu.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void initView() {
        mWebview.loadUrl(url);
//        mWebview.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                view.loadUrl(request.toString());
//                return true;
//            }
//        });
    }

    @Override
    protected void initData() {

    }
}
