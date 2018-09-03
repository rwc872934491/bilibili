package org.lanqiao.dao;

import org.lanqiao.entity.FanInfo;
import org.lanqiao.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class FanInfoDaoImpl extends BaseDao<FanInfo> implements FanInfoDao {
    public int AddFanInfo(FanInfo fanInfo){
        return executeUpdate("INSERT INTO FanInfo (userId1, userId2) values (?, ?)",
                new Object[]{fanInfo.getUserId1(), fanInfo.getUserId2()});
    }

    public List<UserInfo> ShowFanInfo(int userId){
        List<UserInfo> list = new ArrayList<UserInfo>();
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        list = userInfoDao.executeQuery("SELECT A.* FROM UserInfo A, (SELECT userId2 FROM FanInfo WHERE userId1 = ?) B WHERE A.userId = B.userId2",
                new Object[]{userId});
        return list;
    }

    public static void main(String[] args){
        FanInfoDaoImpl fanInfoDao = new FanInfoDaoImpl();
        List<UserInfo> list = new ArrayList<UserInfo>();
        list = fanInfoDao.ShowFanInfo(20);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getUserId() + " " + list.get(i).getNickname() + " " + list.get(i).getUserName());
        }

    }
}
