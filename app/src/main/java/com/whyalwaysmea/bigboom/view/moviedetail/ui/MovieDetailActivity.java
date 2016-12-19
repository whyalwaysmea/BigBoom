package com.whyalwaysmea.bigboom.view.moviedetail.ui;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whyalwasymea.bigboom.dao.DBMovieDao;
import com.whyalwasymea.bigboom.dao.DaoSession;
import com.whyalwaysmea.bigboom.MainActivity;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseFragment;
import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.base.MvpActivity;
import com.whyalwaysmea.bigboom.bean.MovieDetail;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;
import com.whyalwaysmea.bigboom.db.DBManager;
import com.whyalwaysmea.bigboom.di.component.DaggerMovieComponent;
import com.whyalwaysmea.bigboom.di.module.MovieModule;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;
import com.whyalwaysmea.bigboom.view.moviedetail.presenter.MovieDetailPresenterImp;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter.CommentPageAdapter;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter.MovicDetailCastAdapter;
import com.whyalwaysmea.bigboom.view.moviedetail.ui.adapter.MoviePhotoAdapter;
import com.whyalwaysmea.bigboom.view.moviedetail.view.IMovieDetailView;
import com.whyalwaysmea.bigboom.utils.MeasureUtil;
import com.whyalwaysmea.bigboom.utils.ShareUtils;
import com.whyalwaysmea.bigboom.utils.StatusBarUtil;
import com.whyalwaysmea.bigboom.widget.ExpandableTextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

import static com.whyalwaysmea.bigboom.R.id.movie_detail_bg;
import static com.whyalwaysmea.bigboom.R.id.toolbar;

public class MovieDetailActivity extends MvpActivity<IMovieDetailView, MovieDetailPresenterImp> implements IMovieDetailView {

    @BindView(movie_detail_bg)
    ImageView mMovieDetailBg;
    @BindView(toolbar)
    Toolbar mToolbar;
    @BindView(R.id.movie_detail_toolbarlayout)
    CollapsingToolbarLayout mMovieDetailToolbarlayout;
    @BindView(R.id.movie_detail_appbarlayout)
    AppBarLayout mMovieDetailAppbarlayout;
    @BindView(R.id.root_view)
    CoordinatorLayout mRootView;

    @BindView(R.id.genres)
    TextView mGenres;
    @BindView(R.id.original_title)
    TextView mOriginalTitle;
    @BindView(R.id.durations)
    TextView mDurations;
    @BindView(R.id.pubdates)
    TextView mPubdates;
    @BindView(R.id.average_rating)
    TextView mAverageRating;
    @BindView(R.id.ratingBar_hots)
    AppCompatRatingBar mRatingBarHots;
    @BindView(R.id.rating_nums)
    TextView mRatingNums;
    @BindView(R.id.rating_layout)
    LinearLayout mRatingLayout;
    @BindView(R.id.expand_text_view)
    ExpandableTextView mExpandTextView;
    @BindView(R.id.directors_recyclerview)
    RecyclerView mDirectorsRecyclerview;
    @BindView(R.id.photos_recyclerview)
    RecyclerView mPhotosRecyclerview;
    @BindView(R.id.id_stickynavlayout_indicator)
    TabLayout mTabLayout;
    @BindView(R.id.id_stickynavlayout_viewpager)
    ViewPager mCommentViewpage;

    private int mX, mY;
    private String mId;

    private LinearLayoutManager mCastLayoutManager, mPhotoLayoutManager;
    private List<MovieDetail.CastsBean> mCastsBeanList;
    private MovicDetailCastAdapter mMovicDetailCastAdapter;
    private MoviePhotoAdapter mMoviePhotoAdapter;
    private MovieDetail mMovieDetail;
    private DaoSession mDaoSession;
    private DBMovieDao mDbMovieDao;

    @Inject
    MovieDetailPresenterImp mPresenter;

    @Override
    protected MovieDetailPresenterImp createPresenter(BaseView view) {
        return new MovieDetailPresenterImp(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // 设置全屏，并且不会Activity的布局让出状态栏的空间
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        DaggerMovieComponent
                .builder()
                .movieModule(new MovieModule(this))
                .build()
                .inject(this);

        StatusBarUtil.setTransparent(this);
        initView();
        initData();

    }

    @Override
    protected void initData() {
        mPresenter.loadSubject(mId);
    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            // 设置Toolbar对顶部的距离
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mMovieDetailBg
                    .getLayoutParams();
            layoutParams.topMargin = -MeasureUtil.getStatusBarHeight(this);
            mMovieDetailBg.setLayoutParams(layoutParams);
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {

            // 设置Toolbar对顶部的距离
            final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) toolbar
                    .getLayoutParams();
            layoutParams.topMargin = MeasureUtil.getStatusBarHeight(this);
        }

        mToolbar.setNavigationIcon(AppCompatResources.getDrawable(this, R.drawable.ic_action_clear));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mX = getIntent().getIntExtra("X", 0);
        mY = getIntent().getIntExtra("Y", 0);
        mId = getIntent().getStringExtra("ID");

        mRootView.post(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Animator animator = createRevealAnimator(false, mX, mY);
                    animator.start();
                }
            }
        });

        mCastLayoutManager = new LinearLayoutManager(this);
        mCastLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mDirectorsRecyclerview.setLayoutManager(mCastLayoutManager);

        mPhotoLayoutManager = new LinearLayoutManager(this);
        mPhotoLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mPhotosRecyclerview.setLayoutManager(mPhotoLayoutManager);

        String[] titles = getResources().getStringArray(R.array.comment_titles);
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(ReviewFragment.newInstance(mId));
        fragments.add(CommentFragment.newInstance(mId));
        mCommentViewpage.setAdapter(new CommentPageAdapter(getSupportFragmentManager(), titles, fragments));
        mCommentViewpage.setOffscreenPageLimit(1);
        mCommentViewpage.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mCommentViewpage);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));

    }


    @Override
    public void setDetailData(MovieDetail detailData) {
        mMovieDetail = detailData;

        mDaoSession = DBManager.getInstance().getDaoSession();
        mDbMovieDao = mDaoSession.getDBMovieDao();
        List<DBMovie> list = mDbMovieDao.queryBuilder().where(DBMovieDao.Properties.MovieId.eq(mMovieDetail.getId())).build().list();
        if(list.isEmpty()) {
            DBMovie movie = new DBMovie();
            movie.setMovieId(mMovieDetail.getId());
            movie.setImgUrl(mMovieDetail.getImages().getLarge());
            mDbMovieDao.insert(movie);
        }


        ImageUtils.getInstance().display(mMovieDetailBg, detailData.getImages().getLarge());
        mToolbar.setTitle(detailData.getTitle());
        setSupportActionBar(mToolbar);
        StringBuffer sbGenres = new StringBuffer();
        for (int i = 0; i < detailData.getGenres().size(); i++) {
            if (i != detailData.getGenres().size() - 1) {
                sbGenres.append(detailData.getGenres().get(i) + "/");
            } else {
                sbGenres.append(detailData.getGenres().get(i));
            }
        }
        mGenres.setText(getString(R.string.genres) + sbGenres.toString());

        StringBuffer sbPubdates = new StringBuffer();
        for (int i = 0; i < detailData.getPubdates().size(); i++) {
            if (i != detailData.getPubdates().size() - 1) {
                sbPubdates.append(detailData.getPubdates().get(i) + "/");
            } else {
                sbPubdates.append(detailData.getPubdates().get(i));
            }
        }
        mPubdates.setText(getString(R.string.pubdates) + sbPubdates.toString());

        StringBuffer sbDurations = new StringBuffer();
        for (int i = 0; i < detailData.getDurations().size(); i++) {
            if (i != detailData.getDurations().size() - 1) {
                sbDurations.append(detailData.getDurations().get(i) + "/");
            } else {
                sbDurations.append(detailData.getDurations().get(i));
            }
        }
        mDurations.setText(getString(R.string.durations) + sbDurations.toString());
        mOriginalTitle.setText(getString(R.string.original_title) + detailData.getOriginal_title());

        mAverageRating.setText("" + detailData.getRating().getAverage());
        mRatingNums.setText("" + detailData.getRatings_count());
        mRatingBarHots.setRating(detailData.getRating().getAverage());
        mExpandTextView.setText(detailData.getSummary());

        mCastsBeanList = new ArrayList<>();
        mCastsBeanList.addAll(detailData.getDirectors());
        mCastsBeanList.addAll(detailData.getCasts());
        mMovicDetailCastAdapter = new MovicDetailCastAdapter(this);
        mMovicDetailCastAdapter.addData(mCastsBeanList);
        mDirectorsRecyclerview.setAdapter(mMovicDetailCastAdapter);

        mMoviePhotoAdapter = new MoviePhotoAdapter(this);
        mMoviePhotoAdapter.addData(detailData.getPhotos());
        Observable.just(detailData.getBloopers(), detailData.getTrailers(), detailData.getTrailers())
                .subscribe(clipsBeen -> {
                    if(!clipsBeen.isEmpty()) {
                        mMoviePhotoAdapter.setVideoURL(clipsBeen.get(0).getMedium());
                        mMoviePhotoAdapter.setMovieDetail(detailData);
                    }
                });
        mPhotosRecyclerview.setAdapter(mMoviePhotoAdapter);
        mMoviePhotoAdapter.setMovieId(detailData.getId());
    }

    // 动画
    private Animator createRevealAnimator(boolean reversed, int x, int y) {
        float hypot = (float) Math.hypot(mRootView.getHeight(), mRootView.getWidth());
        float startRadius = reversed ? hypot : 0;
        float endRadius = reversed ? 0 : hypot;

        Animator animator = ViewAnimationUtils.createCircularReveal(
                mRootView, x, y,
                startRadius,
                endRadius);
        animator.setDuration(800);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        if (reversed)
            animator.addListener(animatorListener);
        return animator;
    }

    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            mRootView.setVisibility(View.INVISIBLE);
            finish();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    };

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, mX, mY);
            animator.start();
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));

                return true;
            case R.id.action_share:
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.your_friend));
                sb.append(getString(R.string.share_movie));
                sb.append(mMovieDetail.getTitle());
                sb.append(getString(R.string.share_end));
                sb.append(mMovieDetail.getShare_url());
                ShareUtils.share(this, sb.toString(), null);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (item.getIcon() instanceof Animatable) {
                        ((Animatable) item.getIcon()).start();
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDaoSession = null;
        mDbMovieDao = null;
    }
}
