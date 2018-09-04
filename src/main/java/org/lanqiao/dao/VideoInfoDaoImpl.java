package org.lanqiao.dao;

import org.lanqiao.entity.VideoInfo;

import java.util.ArrayList;
import java.util.List;

public class VideoInfoDaoImpl extends BaseDao<VideoInfo> implements VideoInfoDao {
    public List<VideoInfo> ShowVideoInfo(int pageNum, int pageSize){
        return executeQuery("SELECT * FROM VideoInfo ORDER BY videoId LIMIT ?, ?",
                new Object[]{(pageNum - 1) * pageSize, pageSize});
    }

    public int DeleteVideo(int videoId){
        return executeUpdate("DELETE FROM VideoInfo WHERE videoId = ?",
                new Object[]{videoId});
    }

    public static void main(String[] args){
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        int ret = videoInfoDao.DeleteVideo(6);
        System.out.println(ret);
    }
}
