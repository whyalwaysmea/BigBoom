package com.whyalwaysmea.bigboom.view.menu.presenter;

import com.whyalwaysmea.bigboom.base.BasePresenter;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;
import com.whyalwaysmea.bigboom.bean.db.HistoryBean;
import com.whyalwaysmea.bigboom.view.menu.model.HistoryModeImp;
import com.whyalwaysmea.bigboom.view.menu.view.IHistoryView;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/24.
 */

public class HistoryPresenterImp extends BasePresenter<IHistoryView> implements IHistoryPresenter {

    private HistoryModeImp mHistoryModeImp;

    public HistoryPresenterImp(IHistoryView iHistoryView) {
        super(iHistoryView);
        mHistoryModeImp = new HistoryModeImp();
    }

    @Override
    public void getHistoryMovies() {
        mView.showLoading();
        mHistoryModeImp.getMovieHistory(new OnLoadCompleteListener<List<DBMovie>>() {
            @Override
            public void onLoadSussess(List<DBMovie> movies) {
                mView.hideLoading();
                mView.showMovies(movies);
            }

            @Override
            public void onLoadFailed(String error) {
                mView.hideLoading();
            }
        });
    }

    @Override
    public void getHistoryCasts() {
        mView.showLoading();
        mHistoryModeImp.getCastHistory(new OnLoadCompleteListener<List<DBCast>>() {
            @Override
            public void onLoadSussess(List<DBCast> casts) {
                mView.hideLoading();
                mView.showCasts(casts);
            }

            @Override
            public void onLoadFailed(String error) {
                mView.hideLoading();
            }
        });
    }

    @Override
    public void delHistory(HistoryBean historyBean) {
        mView.showLoading();
        mHistoryModeImp.delHistory(historyBean, new OnLoadCompleteListener<Boolean>() {
            @Override
            public void onLoadSussess(Boolean aBoolean) {
                mView.delHistorySuccess();
            }

            @Override
            public void onLoadFailed(String error) {
                mView.hideLoading();
            }
        });
        mView.hideLoading();
    }

}
