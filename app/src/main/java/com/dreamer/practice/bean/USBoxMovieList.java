package com.dreamer.practice.bean;

import java.util.List;

/**
 * Created by dreamer on 2015/5/30.
 * 北美票房接口返回的数据
 */
public class USBoxMovieList {
    /**
     * 票房标题
     */
    private String title;
    /**
     * 票房日期
     */
    private String date;
    /**
     * 电影列表
     */
    private List<USBoxMovie> subjects;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<USBoxMovie> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<USBoxMovie> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "USBoxMovieList{" +
                "date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
