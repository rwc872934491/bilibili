package org.lanqiao.dao;

import org.lanqiao.entity.UserInfo;
import org.lanqiao.entity.VideoInfo;

import java.util.List;

import org.lanqiao.entity.VideoInfo;

public interface VideoInfoDao {
    //通过视频编号分页显示所有视频
    public List<VideoInfo> ShowVideoInfo(int pageNum, int pageSize);

    //根据视频Id删除某条视频
    public int DeleteVideo(int videoId);

    //根据一级菜单编号显示所有视频
    public List<VideoInfo> ShowTypeOneVideo(int typeId1);

    //根据二级菜单编号显示所有视频
    public  List<VideoInfo> ShowTypeTwoVideo(int typeId2);
    public int InsertVideoInfo(VideoInfo videoinfo);


    //根据视频编号得到视频对象
    public List<VideoInfo> GetVedioInfo(int videoId);

    //根据视频编号增加点击量
    public int ClickVideo(int videoId);

    //根据视频编号显示整个对象
    public List<VideoInfo> ClickShow(int videoId);

    //根据视频编号找到用户对象(通过List传)
    public List<UserInfo> ShowVideoUser(int videoId);

    //根据上传人编号取到所有视频列表
    public List<VideoInfo> ShowVideoList(int userId);

    //根据模糊信息找到视频列表
    public List<VideoInfo> ShowVideoListFromMOHU(String videoName);


}