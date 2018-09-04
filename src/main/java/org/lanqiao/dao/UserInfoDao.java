package org.lanqiao.dao;

import org.lanqiao.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    public int updateUserInfo(UserInfo user);

    public List<UserInfo> showUserInfo(int userId);

    public UserInfo checkUser(UserInfo userInfo);

    public int insertUser(UserInfo userInfo);

    public UserInfo getUserInfo(String userName);

    public List<UserInfo> CheckUserName(String userName);

    public int CountUser();

    public int ChangeLocked(int userId);

    public int updateUserImage(String userImage, int userId);
}
