package org.lanqiao.entity;

import java.util.Date;

public class UserInfoAndReviewInfo {
    public UserInfoAndReviewInfo() {

    }

    public UserInfoAndReviewInfo(int userId, int videoId, String reviewContent, int reviewTop, int reviewFloor) {
        this.userId = userId;
        this.videoId = videoId;
        this.reviewContent = reviewContent;
        this.reviewTop = reviewTop;
        this.reviewFloor = reviewFloor;
    }

    public UserInfoAndReviewInfo(int userId, int videoId, String reviewContent, int reviewTop) {
        this.userId = userId;
        this.videoId = videoId;
        this.reviewContent = reviewContent;
        this.reviewTop = reviewTop;
    }

    private String userName;
    private String nickname;
    private String userImage;

    private int reviewId;
    private int userId;
    private int videoId;
    private String reviewContent;
    private int reviewTop;
    private int reviewFloor;
    private int reviewPraise;        //可为空
    private int reviewUnpraise;      //可为空
    private Date reviewTime;          //可为空

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
