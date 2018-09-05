package org.lanqiao.dao;

import org.lanqiao.entity.ReviewResult;

import java.util.ArrayList;
import java.util.List;


public class ReviewReultDaoImpl extends BaseDao<ReviewResult>implements ReviewResultDao{
    public List<ReviewResult> ShowData(int userId){
        return executeQuery("select userId , sum(reviewTop) as sumReviewTop,sum(reviewPraise) as sumReviewPraise from ReviewInfo where userId=? group by userId",new Object[]{userId});

    }

    public static void main(String[]args){
        ReviewReultDaoImpl reviewReultDao=new ReviewReultDaoImpl();
        List<ReviewResult> list = new ArrayList <ReviewResult>();
        list = reviewReultDao.ShowData(1);
        System.out.println(list.size());
        System.out.println(list.get(0).getUserId() + " " + list.get(0).getSumReviewTop() + " "
        + list.get(0).getSumreviwPraise());

    }
}
