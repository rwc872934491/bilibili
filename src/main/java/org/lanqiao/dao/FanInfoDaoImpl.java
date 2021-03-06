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

    //根据主人编号,得到粉丝数量
    public int CountFan(int userId){
        return getRecordCount("Select count(*) From FanInfo Where userId1 = ?",
                new Object[]{userId});
    }

    //得到FanInfo中是否有这条数据
    public int ExsistFaninfo(int userId1, int userId2){
        List<FanInfo> list = new ArrayList<FanInfo>();
        list = executeQuery("Select * From FanInfo Where userId1 = ? And userId2 = ?",
                new Object[]{userId1, userId2});
        if(list.size() > 0)
            return 1;
        else
            return 0;
    }

    //根据两人编号删除这条记录(要求这两人的记录确实存在)
    public int DeleteFaninfo(int userId1, int userId2){
        return executeUpdate("Delete From FanInfo Where userId1 = ? And userId2 = ?",
                new Object[]{userId1, userId2});
    }

    public static void main(String[] args){

    }

}
