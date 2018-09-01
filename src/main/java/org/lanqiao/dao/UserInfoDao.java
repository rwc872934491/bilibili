package org.lanqiao.dao;

import org.lanqiao.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    public int insertUserInfo(UserInfo user);
    public List<UserInfo> showUserInfo(int userId);
}
