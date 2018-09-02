package org.lanqiao.dao;

import org.lanqiao.entity.ReviewInfo;

import java.util.List;

public class ReviewInfoDaoImpl extends BaseDao<ReviewInfo> implements ReviewInfoDao {
    @Override
    public List<ReviewInfo> ShowReview(int pageNum, int pageSize) {
        return executeQuery("select reviewContent,reviewTime,reviewPraise,reviewUnpraise,reviewFloor,reviewId from ReviewInfo where reviewTop=0 order by reviewFloor DESC LIMIT ?,?",new Object[]{(pageNum-1)*pageSize,pageSize});//1,2,3   (0/5/10)
    }

    @Override
    public List<ReviewInfo> ShowBackReview(int userid, int pageNum, int pageSize) {
        return executeQuery("select reviewContent,reviewTime,reviewPraise from ReviewInfo where reviewTop=? order by reviewTime DESC LIMIT ?,?",new Object[]{userid,(pageNum-1)*pageSize,pageSize});
    }

    @Override
    public int AddReview(ReviewInfo reviewInfo) {
        return executeUpdate("insert into ReviewInfo(userId,videoId,reviewContent,reviewTop,reviewFloor,reviewPraise,reviewUnpraise) values(?,?,?,?,?,?,?)",new Object[]{reviewInfo.getUserId(),reviewInfo.getVideoId(),reviewInfo.getReviewContent(),reviewInfo.getReviewTop(),reviewInfo.getReviewFloor(),0,0});

    }

    @Override
    public int AddBackReview(ReviewInfo reviewInfo) {
        return executeUpdate("insert into ReviewInfo(userId,videoId,reviewContent,reviewTop,reviewFloor,reviewPraise) values(?,?,?,?,?,?)",new Object[]{reviewInfo.getUserId(),reviewInfo.getVideoId(),reviewInfo.getReviewContent(),reviewInfo.getReviewTop(),0,0});

    }

    @Override
    public int AddTrueReview() {
        return 0;
    }

    @Override
    public int AddFlaseReview() {
        return 0;
    }

    @Override
    public int ReviewCount() {
        return getRecordCount("select count(*) from ReviewInfo where reviewTop=0");
    }

    @Override
    public int MaxFloor() {
        return getMaxFloor("select Max(reviewFloor) from ReviewInfo");
    }
}
