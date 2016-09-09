package com.whyalwaysmea.bigboom.bean;

import java.util.List;

/**
 * Created by Long
 * on 2016/9/9.
 */
public class MovieListResponse {
    private int count;
    private int start;
    private int total;
    private String title;
    private List<MovieInfo> subjects;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieInfo> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieInfo> subjects) {
        this.subjects = subjects;
    }
}
