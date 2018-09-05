package org.lanqiao.entity;

import java.util.Date;

public class VideoInfo {
    public VideoInfo() {

    }

    public VideoInfo(String videoName, int videoType) {
        this.videoName = videoName;
        this.videoType = videoType;
    }

    private int videoId;
    private String videoName;
    private int videoType;
    private int videoContributorId;
    private Date videoTime;
    private String videoImage;
    private int videoClick;
    private int videoPraise;
    private int videoCollection;
    private int videoReview;
    private int videoBoom;
    private String videoPath;

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }

    public int getVideoContributorId() {
        return videoContributorId;
    }

    public void setVideoContributorId(int videoContributorId) {
        this.videoContributorId = videoContributorId;
    }

    public Date getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public int getVideoClick() {
        return videoClick;
    }

    public void setVideoClick(int videoClick) {
        this.videoClick = videoClick;
    }

    public int getVideoPraise() {
        return videoPraise;
    }

    public void setVideoPraise(int videoPraise) {
        this.videoPraise = videoPraise;
    }

    public int getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(int videoCollection) {
        this.videoCollection = videoCollection;
    }

    public int getVideoReview() {
        return videoReview;
    }

    public void setVideoReview(int videoReview) {
        this.videoReview = videoReview;
    }

    public int getVideoBoom() {
        return videoBoom;
    }

    public void setVideoBoom(int videoBoom) {
        this.videoBoom = videoBoom;
    }
}