package com.whyalwaysmea.bigboom.view.cast.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.whyalwasymea.bigboom.dao.DBCastDao;
import com.whyalwasymea.bigboom.dao.DaoSession;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.CastDetail;
import com.whyalwaysmea.bigboom.bean.CastWork;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.db.DBManager;
import com.whyalwaysmea.bigboom.di.component.DaggerCastComponent;
import com.whyalwaysmea.bigboom.di.module.CastModule;
import com.whyalwaysmea.bigboom.view.cast.presenter.CastPresenterImp;
import com.whyalwaysmea.bigboom.view.cast.ui.adapter.CastAdapter;
import com.whyalwaysmea.bigboom.view.cast.ui.adapter.CastWorksAdapter;
import com.whyalwaysmea.bigboom.view.cast.view.ICastDetailView;
import com.whyalwaysmea.bigboom.utils.DensityUtils;
import com.whyalwaysmea.bigboom.widget.FlexibleScrollView;
import com.whyalwaysmea.bigboom.widget.GridMarginDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.whyalwaysmea.bigboom.R.id.profile_layout;

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
    @BindView(profile_layout)
    FrameLayout mProfileLayout;
    @BindView(R.id.works_recyclerview)
    RecyclerView mWorksRecyclerview;
    @BindView(R.id.all_works)
    TextView mAllWorks;
    @BindView(R.id.year)
    TextView mYear;
    @BindView(R.id.collect_cast)
    ImageView mCollectCast;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout mSwiperefreshlayout;
    @BindView(R.id.content_view)
    FlexibleScrollView mContentView;

    private String mCastId;
    private CastDetail mCastDetail;

    private GridLayoutManager mGridLayoutManager;
    private LinearLayoutManager mLinearLayoutManager;
    private CastAdapter mCastAdapter;
    private CastWorksAdapter mCastWorksAdapter;

    @Inject
    CastPresenterImp mPresenter;

    @Override
    protected CastPresenterImp createPresenter(BaseView view) {
//        return new CastPresenterImp(this);
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_detail);
        ButterKnife.bind(this);

        DaggerCastComponent
                .builder()
                .castModule(new CastModule(this))
                .build()
                .inject(this);

        init();
    }

    @Override
    protected void initData() {
        mCastId = getIntent().getStringExtra(Constants.KEY.CASTID);
        if (!TextUtils.isEmpty(mCastId)) {
            mPresenter.getCastDetail(mCastId);
            mPresenter.getCastWorks(mCastId, 0);
        }
    }

    @Override
    protected void initView() {
        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);
        RxToolbar.navigationClicks(mToolbar).subscribe(aVoid -> finish());

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

        mCastAdapter = new CastAdapter(this);
        mPhotosRecyclerview.setAdapter(mCastAdapter);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mCastWorksAdapter = new CastWorksAdapter(this);
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

        mProfileLayout.setOnClickListener(v -> {
            if (mCastDetail != null) {
                Intent intent = new Intent(mContext, CastInfoActivity.class);
                intent.putExtra(Constants.KEY.CAST, mCastDetail);
                startActivity(intent);
            }
        });

        mAllWorks.setOnClickListener(v -> {
            if (mCastId != null) {
                Intent intent = new Intent(mContext, AllWorksActivity.class);
                intent.putExtra(Constants.KEY.CASTID, mCastId);
                startActivity(intent);
            }
        });


    }

    @OnClick(R.id.collect_cast)
    public void collectCast() {
        DaoSession daoSession = DBManager.getInstance().getDaoSession();
        DBCastDao dbCastDao = daoSession.getDBCastDao();
        List<DBCast> list = dbCastDao.queryBuilder().where(DBCastDao.Properties.CastId.eq(mCastDetail.getId())).build().list();
        if (list.isEmpty()) {
            DBCast dbCast = new DBCast();
            dbCast.setCastId(mCastDetail.getId());
            dbCast.setImgUrl(mCastDetail.getPhotos().get(0).getImage());
            dbCastDao.insert(dbCast);
        }

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
            mCastDetail = castDetail;
            mToolbar.setTitle(castDetail.getName());
            mName.setText(castDetail.getName());
            mNameEn.setText(castDetail.getName_en());
            mProfileContent.setText(castDetail.getSummary());

            mCastAdapter.addData(castDetail.getPhotos());
            mCastAdapter.setCastId(mCastId);
            mCastAdapter.setCastName(castDetail.getName());

            collectCast();
        } else if (o instanceof CastWork) {
            CastWork castWork = (CastWork) o;
            mCastWorksAdapter.addData(castWork.getWorks());
            mAllWorks.setText(mContext.getResources().getString(R.string.all_works, castWork.getTotal() + ""));
        }
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
        mSwiperefreshlayout.setEnabled(true);
        mContentView.setVisibility(View.VISIBLE);
    }
}
