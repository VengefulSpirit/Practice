package com.dreamer.practice.bean;

/**
 * 影人
 */
public class SimpleCelebrity {
	/**
	 * 影人条目id
	 */
	private String id;
	/**
	 * 中文名
	 */
	private String name;
	/**
	 * 影人头像
	 */
	private Poster avatars;

	/**
	 * 艺人类型，1.导演 2.演员
	 */
	private int type;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Poster getAvatars() {
		return avatars;
	}

	public void setAvatars(Poster avatars) {
		this.avatars = avatars;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SimpleCelebrity [id=" + id + ", name=" + name + ", avatars="
				+ avatars + "]";
	}

}
