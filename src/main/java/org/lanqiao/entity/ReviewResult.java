package org.lanqiao.entity;

public class ReviewResult {
    private int userId;
    private int sumReviewTop;
    private int sumReviewPraise;

    // return executeQuery("select userId sum(reviewTop) \"sumReviewTop\",sum(reviewPraise) \"sumReviewPraise\" from ReviewInfo where userId=? group by userId;");

    public ReviewResult() {
    }
    public ReviewResult(int sumReviewTop, int sumReviewPraise) {
        this.sumReviewTop = sumReviewTop;
        this.sumReviewPraise = sumReviewPraise;
    }
    public ReviewResult(int userId, int sumReviewTop, int sumReviewPraise) {
        this.userId = userId;
        this.sumReviewTop = sumReviewTop;
        this.sumReviewPraise = sumReviewPraise;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSumReviewTop() {
        return sumReviewTop;
    }

    public void setSumReviewTop(int sumReviewTop) {
        this.sumReviewTop = sumReviewTop;
    }

    public int getSumreviwPraise() {
        return sumReviewPraise;
    }

    public void setSumreviwPraise(int sumreviwPraise) {
        this.sumReviewPraise = sumreviwPraise;
    }

    @Override
    public String toString() {
        return "ReviewResult{" +
                "userId=" + userId +
                ", sumReviewTop=" + sumReviewTop +
                ", sumreviwPraise=" + sumReviewPraise +
                '}';
    }
}
