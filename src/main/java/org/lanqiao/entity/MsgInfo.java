package org.lanqiao.entity;

import java.util.Date;

public class MsgInfo {
    private int msgId;
    private String msgContent;
    private int msgSender;
    private int msgReceiver;
    private Date msgTime;
    private int msgIndentity;

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
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

    public int getMsgIndentity() {
        return msgIndentity;
    }

    public void setMsgIndentity(int msgIndentity) {
        this.msgIndentity = msgIndentity;
    }

    public MsgInfo(int msgId, String msgContent, int msgSender, int msgReceiver, int msgIndentity) {
        this.msgId = msgId;
        this.msgContent = msgContent;
        this.msgSender = msgSender;
        this.msgReceiver = msgReceiver;
        this.msgIndentity = msgIndentity;
    }

    public MsgInfo(String msgContent) {
        this.msgContent = msgContent;
    }

    public MsgInfo(String msgContent, int msgSender) {
        this.msgContent = msgContent;
        this.msgSender = msgSender;
    }
    public MsgInfo(int msgSender, int msgReceiver) {
        this.msgSender=msgSender;
        this.msgReceiver=msgReceiver;
    }


    public MsgInfo() {

    }

    public MsgInfo(String msgContent, int msgSender, int msgReceiver) {
        this.msgContent = msgContent;
        this.msgSender = msgSender;
        this.msgReceiver = msgReceiver;
    }

}
