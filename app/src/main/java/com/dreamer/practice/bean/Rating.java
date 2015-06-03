package com.dreamer.practice.bean;

/**
 * 评分
 */
public class Rating {

    /**
     * 最低评分
     */
    private int min;
    /**
     * 最高评分
     */
    private int max;
    /**
     * 评分
     */
    private float average;
    /**
     * 评星数
     */
    private int stars;

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "average=" + average +
                ", min=" + min +
                ", max=" + max +
                ", stars=" + stars +
                '}';
    }
}
