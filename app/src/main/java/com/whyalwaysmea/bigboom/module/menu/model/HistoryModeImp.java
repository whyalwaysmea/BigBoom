package com.whyalwaysmea.bigboom.module.menu.model;

import com.whyalwasymea.bigboom.dao.DBCastDao;
import com.whyalwasymea.bigboom.dao.DBMovieDao;
import com.whyalwasymea.bigboom.dao.DaoSession;
import com.whyalwaysmea.bigboom.base.OnLoadCompleteListener;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;
import com.whyalwaysmea.bigboom.db.DBManager;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/24.
 */

public class HistoryModeImp implements IHistoryModel {
    @Override
    public void getMovieHistory(int start, OnLoadCompleteListener<List<DBMovie>> completeListener) {
        DaoSession daoSession = DBManager.getInstance().getDaoSession();
        DBMovieDao dbMovieDao = daoSession.getDBMovieDao();
        List<DBMovie> movies = dbMovieDao.queryBuilder().where(DBMovieDao.Properties.Id.between(start, start + 20)).build().list();
        if(!movies.isEmpty()) {
            completeListener.onLoadSussess(movies);
        } else {
            completeListener.onLoadFailed("No more history");
        }
    }

    @Override
    public void getCastHistory(int start, OnLoadCompleteListener<List<DBCast>> completeListener) {
        DaoSession daoSession = DBManager.getInstance().getDaoSession();
        DBCastDao dbCastDao = daoSession.getDBCastDao();
        List<DBCast> casts = dbCastDao.queryBuilder().where(DBCastDao.Properties.Id.between(start, start + 20)).build().list();
        if(!casts.isEmpty()) {
            completeListener.onLoadSussess(casts);
        } else {
            completeListener.onLoadFailed("No more history");
        }
    }

    @Override
    public void onDestroy() {

    }
}
