package org.lanqiao.dao;

import org.lanqiao.entity.UserInfo;

import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    public int insertUserInfo(UserInfo user) {
        return executeUpdate("update UserInfo set nickname = ?,userMark = ?,userSex = ? where userId = '2'", new Object[]{user.getNickname(), user.getUserMark(), user.getUserSex()});
    }

    public List<UserInfo> showUserInfo(int userId) {
        return executeQuery("SELECT nickname,userMark,userSex FROM UserInfo WHERE userId = ?", new Object[]{userId});
    }
}
