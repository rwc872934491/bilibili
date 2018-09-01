package org.lanqiao.entity;

import java.util.Date;

public class UserInfo {
    public UserInfo() {

    }

    public UserInfo(String userName, String password, String nickname) {
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
    }

    private int userId;
    private String userName;
    private String password;
    private String nickname;
    private String userSex;
    private String userMark;
    private String userImage;
    private int userIdentity;
    private Date userLocked;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserMark() {
        return userMark;
    }

    public void setUserMark(String userMark) {
        this.userMark = userMark;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(int userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Date getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(Date userLocked) {
        this.userLocked = userLocked;
    }
}
