package org.lanqiao.entity;

public class FanInfo {
    public FanInfo() {

    }

    public FanInfo(int userId1, int userId2) {
        this.userId1 = userId1;
        this.userId2 = userId2;
    }

    private int fanId;
    private int userId1;
    private int userId2;

    public int getFanId() {
        return fanId;
    }

    public void setFanId(int fanId) {
        this.fanId = fanId;
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }
}
