package org.lanqiao.dao;

import org.lanqiao.entity.MsgInfo;

import java.util.List;

public interface MsgInfoDao {
    public List<MsgInfo> queryUserMessage();
    public int addUserMsg(MsgInfo msgInfo);
}
