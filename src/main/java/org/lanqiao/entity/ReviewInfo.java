package org.lanqiao.entity;

import java.util.Date;

public class ReviewInfo {
    public ReviewInfo() {

    }

    public ReviewInfo(int userId, int videoId, String reviewContent, int reviewTop, int reviewFloor) {
        this.userId = userId;
        this.videoId = videoId;
        this.reviewContent = reviewContent;
        this.reviewTop = reviewTop;
        this.reviewFloor = reviewFloor;
    }

    private int reviewId;
    private int userId;
    private int videoId;
    private String reviewContent;
    private int reviewTop;
    private int reviewFloor;
    private int reviewPraise;
    private int reviewUnpraise;
    private Date reviewTime;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getReviewTop() {
        return reviewTop;
    }

    public void setReviewTop(int reviewTop) {
        this.reviewTop = reviewTop;
    }

    public int getReviewFloor() {
        return reviewFloor;
    }

    public void setReviewFloor(int reviewFloor) {
        this.reviewFloor = reviewFloor;
    }

    public int getReviewPraise() {
        return reviewPraise;
    }

    public void setReviewPraise(int reviewPraise) {
        this.reviewPraise = reviewPraise;
    }

    public int getReviewUnpraise() {
        return reviewUnpraise;
    }

    public void setReviewUnpraise(int reviewUnpraise) {
        this.reviewUnpraise = reviewUnpraise;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }
}
