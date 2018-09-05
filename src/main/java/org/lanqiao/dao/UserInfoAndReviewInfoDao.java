package org.lanqiao.dao;

import org.lanqiao.entity.UserInfoAndReviewInfo;

import java.util.List;

public interface UserInfoAndReviewInfoDao {
    public List<UserInfoAndReviewInfo> ShowUserReview(int videoId, int pageNum, int pageSize);
    public List<UserInfoAndReviewInfo> ShowUserBack(int userid,int pageNum, int pageSize);
}
