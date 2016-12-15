package com.whyalwaysmea.bigboom.view.menu.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;
import com.whyalwaysmea.bigboom.bean.db.HistoryBean;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/30.
 */

public interface IHistoryModel extends BaseModel{

    void getMovieHistory(OnLoadCompleteListener<List<DBMovie>> completeListener);

    void getCastHistory(OnLoadCompleteListener<List<DBCast>> completeListener);

    void delHistory(HistoryBean historyBean, OnLoadCompleteListener<Boolean> listener);
}
