package com.whyalwaysmea.bigboom.module.movielist.presenter;

import com.whyalwaysmea.bigboom.module.movielist.view.IMovieListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Long
 * on 2016/12/1.
 */
public class MovieListPresenterTest {

    @Mock
    private IMovieListView view;

    private MovieListPresenterImp mPresenterImp;

    @Before
    public void setupMocksAndView() {

        MockitoAnnotations.initMocks(this);

        mPresenterImp = new MovieListPresenterImp(view);
    }

    @Test
    public void loadTop250() throws Exception {
        mPresenterImp.loadTop250(0,20);
    }

}