package com.whyalwaysmea.bigboom.module.menu.model;

import com.whyalwaysmea.bigboom.base.BaseModel;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/24.
 */

public interface IHistoryModel extends BaseModel {

    void getMovieHistory(int start, OnLoadCompleteListener<List<DBMovie>> completeListener);

    void getCastHistory(int start, OnLoadCompleteListener<List<DBCast>> completeListener);
}
