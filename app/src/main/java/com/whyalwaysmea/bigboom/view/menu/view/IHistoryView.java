package com.whyalwaysmea.bigboom.view.menu.view;

import com.whyalwaysmea.bigboom.base.BaseView;
import com.whyalwaysmea.bigboom.bean.db.DBCast;
import com.whyalwaysmea.bigboom.bean.db.DBMovie;

import java.util.List;

/**
 * Created by Long
 * on 2016/11/24.
 */

public interface IHistoryView extends BaseView {

    void showMovies(List<DBMovie>movies);

    void showCasts(List<DBCast> casts);

    void delHistorySuccess();
}
