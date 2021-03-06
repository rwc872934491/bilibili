package org.lanqiao.dao;

import net.sf.json.JSONObject;
import org.lanqiao.entity.ReviewInfo;
import org.lanqiao.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class ReviewInfoDaoImpl extends BaseDao<ReviewInfo> implements ReviewInfoDao {
    @Override
    public List<ReviewInfo> ShowReview(int videoid,int pageNum, int pageSize) {
        return executeQuery("select b.reviewId,b.reviewContent,b.reviewTime,b.reviewPraise,b.reviewUnpraise,b.reviewFloor FROM UserInfo a, ReviewInfo b where a.userId = b.userId and b.reviewTop=0 and videoId=? order by b.reviewFloor DESC LIMIT ?,?",new Object[]{videoid, (pageNum-1)*pageSize,pageSize});//1,2,3   (0/5/10)
    }

    @Override
    public List<UserInfo> ShowUserReview(int pageNum, int pageSize) {

        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        return userInfoDao.executeQuery("select a.nickname name,a.userImage image FROM UserInfo a, ReviewInfo b where a.userId = b.userId and b.reviewTop=0 order by b.reviewFloor DESC LIMIT ?,?",new Object[]{(pageNum-1)*pageSize,pageSize});//1,2,3   (0/5/10)
    }

    @Override
    public List<ReviewInfo> ShowBackReview(int userid, int pageNum, int pageSize) {
        return executeQuery("select reviewId,reviewContent,reviewTime,reviewPraise from ReviewInfo where reviewTop=? order by reviewTime DESC LIMIT ?,?",new Object[]{userid,(pageNum-1)*pageSize,pageSize});
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
    public int AddTrueReview(int reviewId) {
        return executeUpdate("Update ReviewInfo SET reviewPraise = reviewPraise + 1 WHERE reviewId = ?",
                new Object[]{reviewId});
    }

    @Override
    public int AddFlaseReview(int reviewId) {
        return executeUpdate("Update ReviewInfo SET reviewUnpraise = reviewUnpraise + 1 WHERE reviewId = ?",
                new Object[]{reviewId});
    }
    @Override
    public int ReviewCount(int videoid) {
        return getMaxFloor("select count(*) from ReviewInfo where reviewTop=0 and videoId = ?",new Object[]{videoid});
    }

    @Override
    public int MaxFloor(int videoId) {
        return getMaxFloor("select Max(reviewFloor) from ReviewInfo Where videoId = ?", new Object[]{videoId});
    }

//    public static void main(String[] args){
//        ReviewInfoDaoImpl reviewInfoDao = new ReviewInfoDaoImpl();
//        int MaxFloor = reviewInfoDao.MaxFloor(39);
//        System.out.println(MaxFloor);
//    }


//    public static void main(String[] args){
//        ReviewInfoDaoImpl reviewInfoDao = new ReviewInfoDaoImpl();
//        int ret = reviewInfoDao.AddTrueReview(1);
//        int re1 = reviewInfoDao.AddFlaseReview(1);
//        System.out.println(ret + re1 + "888888888888");
//    }
}