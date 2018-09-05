package org.lanqiao.dao;

import org.lanqiao.entity.FanInfo;
import org.lanqiao.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class FanInfoDaoImpl extends BaseDao<FanInfo> implements FanInfoDao {
    //根据封装的的对象,即userId1和userId
    public int AddFanInfo(FanInfo fanInfo){
        return executeUpdate("INSERT INTO FanInfo (userId1, userId2) values (?, ?)",
                new Object[]{fanInfo.getUserId1(), fanInfo.getUserId2()});
    }

    //根据主人编号,得到其所有粉丝的用户编号
    public List<UserInfo> ShowFanInfo(int userId){
        List<UserInfo> list = new ArrayList<UserInfo>();
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        list = userInfoDao.executeQuery("SELECT A.* FROM UserInfo A, (SELECT userId2 FROM FanInfo WHERE userId1 = ?) B WHERE A.userId = B.userId2",
                new Object[]{userId});
        return list;
    }

    public static void main(String[] args){

        }

}
