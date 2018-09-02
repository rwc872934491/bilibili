package org.lanqiao.dao;

import org.lanqiao.entity.MsgInfo;

import java.util.List;

public class MsgInfoDaoImpl extends BaseDao<MsgInfo> implements MsgInfoDao {
        @Override
        //消息遍历
        public List<MsgInfo> queryUserMessage() {
            return  executeQuery("select msgSender,msgContent from MsgInfo where msgReceiver=2",new Object[]{});
        }
        //消息发送
        public int addUserMsg(MsgInfo msgInfo) {
            return executeUpdate("insert into MsgInfo(msgContent,msgSender,msgReceiver) values(?,?,?)",new Object[]{msgInfo.getMsgContent(),msgInfo.getMsgSender(),msgInfo.getMsgReceiver()});
    }
}
