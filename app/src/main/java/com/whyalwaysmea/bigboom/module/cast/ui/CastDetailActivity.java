package com.whyalwaysmea.bigboom.module.cast.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.module.cast.presenter.CastPresenterImp;
import com.whyalwaysmea.bigboom.module.cast.ui.adapter.CastAdapter;
import com.whyalwaysmea.bigboom.module.cast.ui.adapter.CastWorksAdapter;
import com.whyalwaysmea.bigboom.module.cast.view.ICastDetailView;
import com.whyalwaysmea.bigboom.utils.DensityUtils;
import com.whyalwaysmea.bigboom.view.GridMarginDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CastDetailActivity extends MvpActivity<ICastDetailView, CastPresenterImp> implements ICastDetailView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.photos_recyclerview)
    RecyclerView mPhotosRecyclerview;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.name_en)
    TextView mNameEn;
    @BindView(R.id.profile_content)
    TextView mProfileContent;
    @BindView(R.id.profile_layout)
    FrameLayout mProfileLayout;
    @BindView(R.id.works_recyclerview)
    RecyclerView mWorksRecyclerview;
    @BindView(R.id.all_works)
    TextView mAllWorks;
    @BindView(R.id.year)
    TextView mYear;

    private String mCastId;

    private GridLayoutManager mGridLayoutManager;
    private LinearLayoutManager mLinearLayoutManager;
    private CastAdapter mCastAdapter;
    private CastWorksAdapter mCastWorksAdapter;

    @Override
    protected CastPresenterImp createPresenter(BaseView view) {
        return new CastPresenterImp(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_detail);
        ButterKnife.bind(this);

        init();
    }

    @Override
    protected void initData() {
        mCastId = getIntent().getStringExtra(Constants.KEY.CASTID);
        if (!TextUtils.isEmpty(mCastId)) {
            mPresenter.getCastDetail(mCastId);
            mPresenter.getCastWorks(mCastId, 10);
        }
    }

    @Override
    protected void initView() {
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);

        mGridLayoutManager = new GridLayoutManager(this, 2);
        mGridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        mPhotosRecyclerview.setLayoutManager(mGridLayoutManager);
        mPhotosRecyclerview.addItemDecoration(new GridMarginDecoration(mContext.getResources().getDimensionPixelSize(R.dimen.gridlayout_margin_decoration2)));

        mCastAdapter = new CastAdapter(this, new ArrayList<>());
        mPhotosRecyclerview.setAdapter(mCastAdapter);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mCastWorksAdapter = new CastWorksAdapter(this, new ArrayList<>());
        mWorksRecyclerview.setLayoutManager(mLinearLayoutManager);
        mWorksRecyclerview.setAdapter(mCastWorksAdapter);

        mWorksRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // 获取到固定的view
                View stickyInfoView = recyclerView.findChildViewUnder(10, DensityUtils.dp2px(mContext, 80));

                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    mYear.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                // Get the sticky view's translationY by the first view below the sticky's height.
                View transInfoView = recyclerView.findChildViewUnder(
                        DensityUtils.dp2px(mContext, 165), DensityUtils.dp2px(mContext, 80));

                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtX = transInfoView.getLeft() - mYear.getMeasuredWidth();
                    if (transViewStatus == CastWorksAdapter.HAS_STICKY_VIEW) {
                        // If the first view below the sticky's height scroll off the screen,
                        // then recovery the sticky view's translationY.
                        if (transInfoView.getLeft() > 0 && transInfoView.getLeft() < mYear.getMeasuredWidth() + 10) {
                            mYear.setTranslationX(dealtX);
                        } else {
                            mYear.setTranslationX(0);
                        }
                    } else if (transViewStatus == CastWorksAdapter.NONE_STICKY_VIEW) {
                        mYear.setTranslationX(0);
                    }
                }
            }
        });
    }

    @Override
    public void showToast(String msg) {
        super.showToast(msg);
        showSnackbar(mToolbar, msg);
    }

    @Override
    public void showDetail(Object o) {
        if (o instanceof CastDetail) {
            CastDetail castDetail = (CastDetail) o;
            mToolbar.setTitle(castDetail.getName());
            mName.setText(castDetail.getName());
            mNameEn.setText(castDetail.getName_en());
            mProfileContent.setText(castDetail.getSummary());

            mCastAdapter.addData(castDetail.getPhotos());
            mCastAdapter.setCastId(mCastId);
            mCastAdapter.setCastName(castDetail.getName());
        } else if (o instanceof CastWork) {
            CastWork castWork = (CastWork) o;
            mCastWorksAdapter.addData(castWork.getWorks());
            mAllWorks.setText(mContext.getResources().getString(R.string.all_works, castWork.getTotal() + ""));
        }
    }
}
