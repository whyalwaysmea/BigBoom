package com.whyalwaysmea.bigboom.view.movielist.presenter;

import android.support.test.runner.AndroidJUnit4;

import com.socks.library.KLog;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.MovieListResponse;
import com.whyalwaysmea.bigboom.view.movielist.model.MovieListModelImp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Long
 * on 2016/12/1.
 */
@RunWith(AndroidJUnit4.class)
public class MovieListPresenterImpTest {


    private MovieListModelImp mImp;

    @Before
    public void setUp() throws Exception {
        mImp = new MovieListModelImp();
    }

    @After
    public void tearDown() throws Exception {
        mImp.onDestroy();
    }

    @Test
    public void loadTop250() throws Exception {
        mImp.loadTop250(0, 10, new OnLoadCompleteListener<MovieListResponse>() {
            @Override
            public void onLoadSussess(MovieListResponse movieListResponse) {
                KLog.e("success");
            }

            @Override
            public void onLoadFailed(String error) {
                KLog.e("failed");

            }
        });
    }

}