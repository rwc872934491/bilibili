package org.lanqiao.dao;

import org.lanqiao.entity.FanInfo;
import org.lanqiao.entity.UserInfo;

import java.util.List;

public interface FanInfoDao {
    public int AddFanInfo(FanInfo fanInfo);
    public List<UserInfo> ShowFanInfo(int userId);
}
