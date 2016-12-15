package com.whyalwaysmea.bigboom.view.menu.presenter;

import com.whyalwaysmea.bigboom.bean.db.HistoryBean;

/**
 * Created by Long
 * on 2016/11/24.
 */

public interface IHistoryPresenter  {

    void getHistoryMovies();

    void getHistoryCasts();

    void delHistory(HistoryBean historyBean);
}
