package com.whyalwaysmea.bigboom.db;

import com.whyalwasymea.bigboom.dao.DaoMaster;
import com.whyalwasymea.bigboom.dao.DaoSession;
import com.whyalwaysmea.bigboom.App;

/**
 * Created by Long
 * on 2016/11/23.
 */

public class DBManager {
    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private DaoSession mDaoSession;

    public DBManager() {
        openHelper = new DaoMaster.DevOpenHelper(App.getApplication(), dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @return
     */
    public static DBManager getInstance() {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager();
                }
            }
        }
        return mInstance;
    }

    public DaoSession getDaoSession() {
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
        return mDaoSession;
    }
}
