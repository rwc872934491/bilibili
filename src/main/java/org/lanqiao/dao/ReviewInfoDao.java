package org.lanqiao.dao;

import org.lanqiao.entity.ReviewInfo;

import java.util.List;

public interface ReviewInfoDao {
    /**
     * 查询、ShowReview     ready
     * 添加、AddReview      click——发表评论
     * 回复、TalkReview     click——回复
     * 点赞、AddTrueReview  click——点赞
     * 倒赞、AddFlaseReview click——倒赞
     *
     */
    public List<ReviewInfo> ShowReview(int bageNum, int pageSize);
    public List<ReviewInfo> ShowBackReview(int userid,int pageNum,int pageSize);
    public int AddReview(ReviewInfo reviewInfo);
    public int AddBackReview(ReviewInfo reviewInfo);
    public int AddTrueReview(int reviewId);
    public int AddFlaseReview(int reviewId);
    public int ReviewCount();
    public int MaxFloor();
}
