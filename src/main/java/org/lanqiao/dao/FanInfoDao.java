package org.lanqiao.dao;

import org.lanqiao.entity.FanInfo;
import org.lanqiao.entity.UserInfo;

import java.util.List;

public interface FanInfoDao {
    //根据封装的的对象,即userId1和userId
    public int AddFanInfo(FanInfo fanInfo);

    //根据主人编号,得到其所有粉丝的用户编号
    public List<UserInfo> ShowFanInfo(int userId);

    //根据主人编号,得到粉丝数量
    public int CountFan(int userId);
}
