package org.lanqiao.dao;

import org.lanqiao.entity.VideoInfo;

import java.util.List;

public interface VideoInfoDao {
    //通过视频编号分页显示所有视频
    public List<VideoInfo> ShowVideoInfo(int pageNum, int pageSize);

    //根据视频Id删除某条视频
    public int DeleteVideo(int videoId);

    //根据一级菜单显示所有视频
    public List<VideoInfo> ShowTypeOneVideo(int typeId1);

    //根据二级菜单显示所有视频
    public  List<VideoInfo> ShowTypeTwoVideo(int typeId2);

    //根据视频编号得到视频对象
    public List<VideoInfo> GetVedioInfo(int videoId);

    //根据视频编号增加点击量
    public int ClickVideo(int videoId);


}