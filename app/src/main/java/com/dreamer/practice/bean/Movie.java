package com.dreamer.practice.bean;

import java.util.Arrays;

/**
 * 
 * @author zhangzixu
 * 
 * 1.json串中并没有出现的字段
 * 		pubdates  如果条目类型是电影则为上映日期，如果是电视剧则为首Ï日期
 * 		mainland_pubdate  大陆上映日期，如果条目类型是电影则为上映日期，如果是电视剧则为首播日期
 * 		pubdate  兼容性数据，未来会去掉，大陆上映日期，如果条目类型是电影则为上映日期，如果是电视剧则为首播日期
 * 		languages  语言
 * 		durations  片长
 * 
 * 2.需要高级用户权限的字段
 * 		trailer_urls  预告片URL，对高级用户以上开放，最多开放4个地址
 * 
 * 3.主动去掉的字段
 * 		popular_reviews  影评，前10条，影评结构
 * 		mobile_url  移动版条目页URL
 * 		do_count  在看人数，如果是电视剧，默认值为0，如果是电影值为null
 * 		douban_site  豆瓣小站
 * 		seasons_count  总季数(tv only)
 * 		current_season  当前季数(tv only)
 * 		episodes_count  当前季的集数(tv only)
 * 		schedule_url  影讯页URL(movie only)
 */
public class Movie {

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
	 * 又名
	 */
	private String[] aka;
	/**
	 * 评分
	 */
	private Rating rating;
	/**
	 * 评分人数
	 */
	private int ratings_count;
	/**
	 * 想看人数
	 */
	private int wish_count;
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
	 * 编剧
	 */
	private SimpleCelebrity[] writers;
	/**
	 * 官方网站
	 */
	private String website;
	/**
	 * 年代
	 */
	private String year;
	/**
	 * 影片类型
	 */
	private String[] genres;
	/**
	 * 制片国家
	 */
	private String[] countries;
	/**
	 * 简介
	 */
	private String summary;
	/**
	 * 短评论数
	 */
	private int comments_count;
	/**
	 * 影评数
	 */
	private int reviews_count;
	/**
	 * 条目页URL
	 */
	private String alt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return original_title;
	}

	public void setOriginalTitle(String original_title) {
		this.original_title = original_title;
	}

	public String[] getAka() {
		return aka;
	}

	public void setAka(String[] aka) {
		this.aka = aka;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public int getRatingsCount() {
		return ratings_count;
	}

	public void setRatingsCount(int ratings_count) {
		this.ratings_count = ratings_count;
	}

	public int getWishCount() {
		return wish_count;
	}

	public void setWishCount(int wish_count) {
		this.wish_count = wish_count;
	}

	public int getCollectCount() {
		return collect_count;
	}

	public void setCollectCount(int collect_count) {
		this.collect_count = collect_count;
	}

	public Poster getImages() {
		return images;
	}

	public void setImages(Poster images) {
		this.images = images;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public SimpleCelebrity[] getDirectors() {
		return directors;
	}

	public void setDirectors(SimpleCelebrity[] directors) {
		this.directors = directors;
	}

	public SimpleCelebrity[] getCasts() {
		return casts;
	}

	public void setCasts(SimpleCelebrity[] casts) {
		this.casts = casts;
	}

	public SimpleCelebrity[] getWriters() {
		return writers;
	}

	public void setWriters(SimpleCelebrity[] writers) {
		this.writers = writers;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public String[] getCountries() {
		return countries;
	}

	public void setCountries(String[] countries) {
		this.countries = countries;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getCommentsCount() {
		return comments_count;
	}

	public void setCommentsCount(int comments_count) {
		this.comments_count = comments_count;
	}

	public int getReviewsCount() {
		return reviews_count;
	}

	public void setReviewsCount(int reviews_count) {
		this.reviews_count = reviews_count;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", original_title="
				+ original_title + ", aka=" + Arrays.toString(aka)
				+ ", rating=" + rating + ", ratings_count=" + ratings_count
				+ ", wish_count=" + wish_count + ", collect_count="
				+ collect_count + ", images=" + images + ", subtype=" + subtype
				+ ", directors=" + Arrays.toString(directors) + ", casts="
				+ Arrays.toString(casts) + ", writers="
				+ Arrays.toString(writers) + ", website=" + website + ", year="
				+ year + ", genres=" + Arrays.toString(genres) + ", countries="
				+ Arrays.toString(countries) + ", summary=" + summary
				+ ", comments_count=" + comments_count + ", reviews_count="
				+ reviews_count + "]";
	}
	
}
