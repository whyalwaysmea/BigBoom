package com.whyalwaysmea.bigboom.view.movielist.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.EmptyViewHolder;
import com.whyalwaysmea.bigboom.bean.MovieInfo;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Long
 * on 2016/9/19.
 */
public class NewMoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WeeklyMovieInfo.SubjectsBean> mWeeklyMovies;
    private List<MovieInfo> mNewMovies;
    private Context mContext;
    private static final int TYPE_EMPTY = 1;
    private static final int TYPE_ONLY_NEW_MOVIES = 2;
    private static final int TYPE_ONLY_WEEKLY_MOVIES = 3;
    private static final int TYPE_ALL = 4;

    private WeeklyMoviesAdapter mWeeklyMoviesAdapter;
    private int mCurrentPage;
    private boolean isAutoPlay;
    private Subscription mSubscribe;


    public NewMoviesAdapter(Context context, List<WeeklyMovieInfo.SubjectsBean> weeklyMovies, List<MovieInfo> newMovies) {
        this.mContext = context;
        this.mWeeklyMovies = weeklyMovies;
        this.mNewMovies = newMovies;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_EMPTY) {
            View emptyView = LayoutInflater.from(mContext).inflate(R.layout.layout_empty, parent, false);
            return new EmptyViewHolder(emptyView);
        } else if(viewType == TYPE_ALL) {
            View viewPagerView = LayoutInflater.from(mContext).inflate(R.layout.weekly_movies_viewpager, parent, false);
            return new WeeklyMoviesHolder(viewPagerView);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.new_movies_item, parent, false);
            return new NewMoviesHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof WeeklyMoviesHolder) {
            WeeklyMoviesHolder weeklyMoviesHolder = (WeeklyMoviesHolder) holder;
            List<WeeklyMovieInfo.SubjectsBean> tempMovies = new ArrayList<>();
            for (int i = 0; i < mWeeklyMovies.size() + 2; i++) {
                if (i == 0) {
                    tempMovies.add(mWeeklyMovies.get(mWeeklyMovies.size() - 1));
                } else if (i == mWeeklyMovies.size() + 1) {
                    tempMovies.add(mWeeklyMovies.get(0));
                } else {
                    tempMovies.add(mWeeklyMovies.get(i-1));
                }
            }

            mWeeklyMoviesAdapter = new WeeklyMoviesAdapter(mContext, tempMovies);
            weeklyMoviesHolder.weeklyViewPager.setAdapter(mWeeklyMoviesAdapter);
            mCurrentPage = 1;
            weeklyMoviesHolder.weeklyViewPager.setCurrentItem(mCurrentPage);
            weeklyMoviesHolder.weeklyViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (weeklyMoviesHolder.weeklyViewPager.getCurrentItem() == 0) {
                        mCurrentPage = 1;
                    }
                    switch (state) {
                        // 闲置中
                        case ViewPager.SCROLL_STATE_IDLE:
                            if (weeklyMoviesHolder.weeklyViewPager.getCurrentItem() == 0) {
                                weeklyMoviesHolder.weeklyViewPager.setCurrentItem(mWeeklyMovies.size() - 2, false);
                            } else if (weeklyMoviesHolder.weeklyViewPager.getCurrentItem() == mWeeklyMovies.size() - 1) {
                                weeklyMoviesHolder.weeklyViewPager.setCurrentItem(1, false);
                            }
                            mCurrentPage = weeklyMoviesHolder.weeklyViewPager.getCurrentItem();
                            isAutoPlay = true;
                            break;
                        // 拖动中
                        case ViewPager.SCROLL_STATE_DRAGGING:
                            isAutoPlay = false;
                            break;
                        // 设置中
                        case ViewPager.SCROLL_STATE_SETTLING:
                            isAutoPlay = true;
                            break;
                    }
                }
            });
            mSubscribe = Observable.interval(5, 5, TimeUnit.SECONDS)
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Long>() {
                        @Override
                        public void call(Long aLong) {
                            if (isAutoPlay) {
                                mCurrentPage++;
                                weeklyMoviesHolder.weeklyViewPager.setCurrentItem(mCurrentPage);
                            }
                        }
                    });
        } else if(holder instanceof NewMoviesHolder) {
            MovieInfo movieInfo;
            if(mNewMovies.isEmpty())
                return;
            if(mNewMovies.size() < getItemCount()) {
                movieInfo = mNewMovies.get(position - 1);
            } else {
                movieInfo = mNewMovies.get(position);
            }
            NewMoviesHolder comingSoonHolder = (NewMoviesHolder) holder;
            ImageUtils.getInstance().display(comingSoonHolder.mComingSoonMoviePic, movieInfo.getImages().getLarge());
            comingSoonHolder.mComingSoonMovieName.setText(movieInfo.getTitle());
            comingSoonHolder.mComingSoonMovieType.setText("类别：" + movieInfo.getGenres().toString());


            StringBuffer time = new StringBuffer();
            time.append("上映：");
            for (int i = 0; i < movieInfo.getPubdates().size(); i++) {
                if(i != movieInfo.getPubdates().size() - 1) {
                    time.append(movieInfo.getPubdates().get(i) + "/");
                } else {
                    time.append(movieInfo.getPubdates().get(i));
                }
            }
            comingSoonHolder.mComingSoonMovieDirectors.setText(time.toString());
            comingSoonHolder.mComingSoonMovieTime.setText("时长：" + movieInfo.getDurations().get(0));


            comingSoonHolder.mNewMoviesRating.setText("" + movieInfo.getRating().getAverage());
            comingSoonHolder.mAppCompatRatingBar.setRating((float) movieInfo.getRating().getAverage());
        }
    }

    @Override
    public int getItemCount() {
        if(mWeeklyMovies.isEmpty() && mNewMovies.isEmpty()) {
            return 1;
        } else if(mWeeklyMovies.size() > 0 && mNewMovies.size() > 0){
            return mNewMovies.size() + 1;
        } else if(mWeeklyMovies.isEmpty() && mNewMovies.size() > 0) {
            return mNewMovies.size();
        } else if(mWeeklyMovies.size() > 0 && mNewMovies.isEmpty()) {
            return mWeeklyMovies.size();
        }
        return 0;
    }


    @Override
    public int getItemViewType(int position) {
        if(mWeeklyMovies.isEmpty() && mNewMovies.isEmpty()) {
            return TYPE_EMPTY;
        } else if(mWeeklyMovies.size() > 0 && mNewMovies.size() > 0 && position == 0){
            return TYPE_ALL;
        } else if(mWeeklyMovies.isEmpty() && mNewMovies.size() > 0) {
            return TYPE_ONLY_NEW_MOVIES;
        } else if(mWeeklyMovies.size() > 0 && mNewMovies.isEmpty()) {
            return TYPE_ONLY_WEEKLY_MOVIES;
        }
        return super.getItemViewType(position);
    }

    class WeeklyMoviesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weekly_viewpager)
        ViewPager weeklyViewPager;

        public WeeklyMoviesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    class NewMoviesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.coming_soon_movie_pic)
        ImageView mComingSoonMoviePic;
        @BindView(R.id.coming_soon_movie_name)
        TextView mComingSoonMovieName;
        @BindView(R.id.coming_soon_movie_type)
        TextView mComingSoonMovieType;
        @BindView(R.id.coming_soon_movie_time)
        TextView mComingSoonMovieTime;
        @BindView(R.id.coming_soon_movie_directors)
        TextView mComingSoonMovieDirectors;
        @BindView(R.id.new_movies_rating)
        TextView mNewMoviesRating;
        @BindView(R.id.ratingBar_hots)
        AppCompatRatingBar mAppCompatRatingBar;

        public NewMoviesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public void unRegist() {
        if(mSubscribe != null && mSubscribe.isUnsubscribed()) {
            mSubscribe.unsubscribe();
        }
    }

    public void addWeeklyMovies(List<WeeklyMovieInfo.SubjectsBean> weeklyMovies) {
        if(this.mWeeklyMovies == null) {
            mWeeklyMovies = new ArrayList<>();
        }
        mWeeklyMovies.addAll(weeklyMovies);
        notifyDataSetChanged();
    }

    public void addNewMovies(List<MovieInfo> movieInfos) {
        if(this.mNewMovies == null) {
            mNewMovies = new ArrayList<>();
        }
        mNewMovies.addAll(movieInfos);
        notifyDataSetChanged();
    }
}
