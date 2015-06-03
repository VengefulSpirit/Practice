package com.dreamer.practice.bean;

import java.util.Arrays;

/**
 * Created by dreamer on 2015/5/18.
 * 这个对象与官网给出的api返回的结构不一样！！！！
 */
public class SimpleMovie {
    /**
     * 电影条目id
     */
    private String id;
    /**
     * 中文名
     */
    private String title;
    /**
     * 原名
     */
    private String original_title;
    /**
     * 评分
     */
    private Rating rating;
    /**
     * 看过人数
     */
    private int collect_count;
    /**
     * 电影海报
     */
    private Poster images;
    /**
     * 条目分类, movie或者tv
     */
    private String subtype;
    /**
     * 导演
     */
    private SimpleCelebrity[] directors;
    /**
     * 主演
     */
    private SimpleCelebrity[] casts;
    /**
     * 年代
     */
    private String year;
    /**
     * 影片类型
     */
    private String[] genres;

    public SimpleCelebrity[] getCasts() {
        return casts;
    }

    public void setCasts(SimpleCelebrity[] casts) {
        this.casts = casts;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public SimpleCelebrity[] getDirectors() {
        return directors;
    }

    public void setDirectors(SimpleCelebrity[] directors) {
        this.directors = directors;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Poster getImages() {
        return images;
    }

    public void setImages(Poster images) {
        this.images = images;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "SimpleMovie{" +
                "casts=" + Arrays.toString(casts) +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", original_title='" + original_title + '\'' +
                ", rating=" + rating +
                ", collect_count=" + collect_count +
                ", images=" + images +
                ", subtype='" + subtype + '\'' +
                ", directors=" + Arrays.toString(directors) +
                ", year='" + year + '\'' +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }
}
