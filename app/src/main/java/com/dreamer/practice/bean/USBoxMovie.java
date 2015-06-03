package com.dreamer.practice.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dreamer on 2015/5/30.
 */
public class USBoxMovie {
    /**
     * 排名
     */
    private int rank;
    /**
     * 票房
     */
    private int box;
    /**
     * 是否是新上映
     */
    @SerializedName("new")
    private boolean isNew;
    /**
     * 电影简单信息
     */
    @SerializedName("subject")
    private SimpleMovie simpleMovie;

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public SimpleMovie getSimpleMovie() {
        return simpleMovie;
    }

    public void setSimpleMovie(SimpleMovie simpleMovie) {
        this.simpleMovie = simpleMovie;
    }

    @Override
    public String toString() {
        return "BoxSubject{" +
                "box=" + box +
                ", rank=" + rank +
                ", isNew=" + isNew +
                ", simpleMovie=" + simpleMovie +
                '}';
    }
}
