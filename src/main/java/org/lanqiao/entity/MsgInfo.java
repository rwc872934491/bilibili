package org.lanqiao.entity;

import java.util.Date;

public class MsgInfo {
    public MsgInfo() {

    }

    public MsgInfo(String msgContent, int msgSender, int msgReceiver) {
        this.msgContent = msgContent;
        this.msgSender = msgSender;
        this.msgReceiver = msgReceiver;
    }

    private int msgID;
    private String msgContent;
    private int msgSender;
    private int msgReceiver;
    private Date msgTime;
    private int msgIdentity;

    public int getMsgID() {
        return msgID;
    }

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public int getMsgSender() {
        return msgSender;
    }

    public void setMsgSender(int msgSender) {
        this.msgSender = msgSender;
    }

    public int getMsgReceiver() {
        return msgReceiver;
    }

    public void setMsgReceiver(int msgReceiver) {
        this.msgReceiver = msgReceiver;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public int getMsgIdentity() {
        return msgIdentity;
    }

    public void setMsgIdentity(int msgIdentity) {
        this.msgIdentity = msgIdentity;
    }
}
