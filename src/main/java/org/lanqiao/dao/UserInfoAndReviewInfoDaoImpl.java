package org.lanqiao.dao;

import org.lanqiao.entity.UserInfoAndReviewInfo;

import java.util.List;

public class UserInfoAndReviewInfoDaoImpl extends BaseDao<UserInfoAndReviewInfo> implements UserInfoAndReviewInfoDao {
    @Override
    public List<UserInfoAndReviewInfo> ShowUserReview(int videoId,int pageNum, int pageSize) {
        return executeQuery("select a.nickname,a.userImage,b.reviewId,b.reviewContent,b.reviewTime,b.reviewPraise,b.reviewUnpraise,b.reviewFloor FROM UserInfo a, ReviewInfo b where a.userId = b.userId and b.reviewTop=0 and b.videoId=? order by b.reviewFloor DESC LIMIT ?,?",new Object[]{videoId,(pageNum-1)*pageSize,pageSize});//1,2,3   (0/5/10)
    }

    @Override
    public List<UserInfoAndReviewInfo> ShowUserBack(int userid,int pageNum, int pageSize) {
        return executeQuery("select a.nickname,a.userImage,b.reviewId,b.reviewContent,b.reviewTime,b.reviewPraise from UserInfo a, ReviewInfo b where a.userId = b.userId and reviewTop=? order by reviewTime DESC LIMIT ?,?",new Object[]{userid,(pageNum-1)*pageSize,pageSize});

    }
}
