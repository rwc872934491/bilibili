package org.lanqiao.dao;

import org.lanqiao.entity.UserInfo;

import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    //    更新个人信息
    public int updateUserInfo(UserInfo user) {
        return executeUpdate("update UserInfo set nickname = ?,userMark = ?,userSex = ? where userId = '2'", new Object[]{user.getNickname(), user.getUserMark(), user.getUserSex()});
    }

    //个人信息页展示信息
    public List<UserInfo> showUserInfo(int userId) {
        return executeQuery("SELECT nickname,userMark,userSex,userImage FROM UserInfo WHERE userId = ?", new Object[]{userId});
    }


    //    登录验证
    public UserInfo checkUser(UserInfo userInfo) {
        List<UserInfo> userList = executeQuery("select userName,password from UserInfo where userName=? and password=?", new Object[]{userInfo.getUserName(), userInfo.getPassword()});
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    //注册验证
    public int insertUser(UserInfo userInfo) {
        return executeUpdate("insert into UserInfo(userName,nickName,password) values(?,?,?)", new Object[]{userInfo.getUserName(), userInfo.getNickname(), userInfo.getPassword()});
    }

    //    获得需要封装入session的信息
    public UserInfo getUserInfo(String userName) {
        List<UserInfo> userList = executeQuery("SELECT userId,userName,password,nickname,userSex,userMark,userImage,userIdentity,userLocked FROM UserInfo WHERE userName = ?", new Object[]{userName});
        return userList.get(0);
    }
    //更新个人头像
    public int updateUserImage(String userImage){
        return executeUpdate("update UserInfo set userImage = ? where userId = '2'", new Object[]{userImage});
    }
}
