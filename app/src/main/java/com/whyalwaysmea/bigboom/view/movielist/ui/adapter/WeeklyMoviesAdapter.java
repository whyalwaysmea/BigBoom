package com.whyalwaysmea.bigboom.view.movielist.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.bean.WeeklyMovieInfo;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.List;

/**
 * Created by Long
 * on 2016/9/15.
 */
public class WeeklyMoviesAdapter extends PagerAdapter{

    private List<WeeklyMovieInfo.SubjectsBean> mData;
    private Context mContext;
    private static String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};

    public WeeklyMoviesAdapter(Context context, List<WeeklyMovieInfo.SubjectsBean> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.weekly_movies_item, container, false);
        ImageView photoItem = (ImageView) view.findViewById(R.id.weekly_item_photo);
        TextView nameItem = (TextView) view.findViewById(R.id.weekly_item_name);
        WeeklyMovieInfo.SubjectsBean movieInfo = mData.get(position);
        ImageUtils.getInstance().display(photoItem, movieInfo.getSubject().getImages().getLarge());
        nameItem.setText("No " + intToRoman(position) + "：" + movieInfo.getSubject().getOriginal_title());
        container.addView(view);
        return view;
    }

    private String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        return roman.append(X[(num%100)/10]).append(I[num%10]).toString();
    }
}

