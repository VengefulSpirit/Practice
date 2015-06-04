package com.dreamer.practice.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 海报
 */
public class Poster {
	/**
	 * 小图
	 */
	private String small;
	/**
	 * 中图
	 */
	@SerializedName("medium")
	private String middle;
	/**
	 * 大图
	 */
	private String large;

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	@Override
	public String toString() {
		return "Poster [small=" + small + ", middle=" + middle + ", large="
				+ large + "]";
	}
}
