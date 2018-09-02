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


//    登录验证
    public UserInfo checkUser(UserInfo userInfo) {
        List<UserInfo> userList=executeQuery("select userName,password from UserInfo where userName=? and password=?",new Object[]{userInfo.getUserName(),userInfo.getPassword()} );
        if(userList.size()>0){
            return userList.get(0);
        }else {
            return null;
        }
    }

   //注册验证
    public int insertUser(UserInfo userInfo) {
        return executeUpdate("insert into UserInfo(userName,nickName,password) values(?,?,?)",new Object[]{userInfo.getUserName(),userInfo.getNickname(),userInfo.getPassword()});
    }

}
