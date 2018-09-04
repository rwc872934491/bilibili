package org.lanqiao.dao;

import org.lanqiao.entity.VideoInfo;

import java.util.List;

public interface VideoInfoDao {
    //通过视频编号显示所有视频
    public List<VideoInfo> ShowVideoInfo(int pageNum, int pageSize);

    //根据视频Id删除某条视频
    public int DeleteVideo(int videoId);
}
