package org.lanqiao.dao;

import org.lanqiao.entity.TypeInfo;
import org.lanqiao.entity.UserInfo;
import org.lanqiao.entity.VideoInfo;

import java.util.ArrayList;
import java.util.List;

public class VideoInfoDaoImpl extends BaseDao<VideoInfo> implements VideoInfoDao {
    public int InsertVideoInfo(VideoInfo videoinfo){
        return executeUpdate("Insert Into VideoInfo (videoName, videoType, userId, videoImage, videoPath) Values (?, ?, ?, ?, ?)",
                new Object[]{videoinfo.getVideoName(), videoinfo.getVideoType(), videoinfo.getUserId(),
                videoinfo.getVideoImage(), videoinfo.getVideoPath()});
    }



    public List<VideoInfo> ShowVideoInfo(int pageNum, int pageSize){
        return executeQuery("SELECT * FROM VideoInfo ORDER BY videoId LIMIT ?, ?",
                new Object[]{(pageNum - 1) * pageSize, pageSize});
    }

    public int DeleteVideo(int videoId){
        return executeUpdate("DELETE FROM VideoInfo WHERE videoId = ?",
                new Object[]{videoId});
    }

    public List<VideoInfo> ShowTypeOneVideo(int typeId1){
        //根据一级菜单编号找到所有二级菜单
        TypeInfoDaoImpl typeInfoDao = new TypeInfoDaoImpl();
        List<TypeInfo> Type_list = new ArrayList<TypeInfo>();
        Type_list = typeInfoDao.ShowTypeTwo(typeId1);
        for (int i = 0; i < Type_list.size(); i++){
            System.out.println(Type_list.get(i).getTypeId() + " " + Type_list.get(i).getTypeName());
        }

        //找到所有二级菜单的所有视频,一条条的放到Last_list中
        List<VideoInfo> Last_list = new ArrayList<VideoInfo>();
        for(int i = 0; i < Type_list.size(); i++){
            List<VideoInfo> Temp_List = new ArrayList<VideoInfo>();
            Temp_List = executeQuery("Select * from VideoInfo where videoType = ?",
                    new Object[]{Type_list.get(i).getTypeId()});
            for (int j = 0; j < Temp_List.size(); j++)
                Last_list.add(Temp_List.get(j));
        }
        return Last_list;
    }

    //通过视频类型(即二级菜单编号)找到视频
    public  List<VideoInfo> ShowTypeTwoVideo(int typeId2){
        return executeQuery("Select * from VideoInfo where videoType = ?",
                new Object[]{typeId2});
    }

    //根据视频编号得到视频对象
    public List<VideoInfo> GetVedioInfo(int videoId){
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = executeQuery("Select * from VideoInfo where videoId = ?",
                new Object[]{videoId});
        return list;
    }

    //根据视频编号增加点击量
    public int ClickVideo(int videoId){
        return executeUpdate("Update VideoInfo Set videoClick = videoClick + 1 Where videoId = ?",
                new Object[]{videoId});
    }

    //根据视频编号得到整个对象
    public List<VideoInfo> ClickShow(int videoId){
        return executeQuery("Select * From VideoInfo Where videoId = ?",
                new Object[]{videoId});
    }

    //根据视频编号找到用户对象(通过List传)
    public List<UserInfo> ShowVideoUser(int videoId){
        //通过视频编号找到用户编号
        List<VideoInfo> video_list = new ArrayList<VideoInfo>();
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        video_list = videoInfoDao.ClickShow(videoId);
        int userId = video_list.get(0).getUserId();

        //通过用户编号找到用户对象
        List<UserInfo> user_List = new ArrayList<UserInfo>();
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        user_List = userInfoDao.executeQuery("Select * From UserInfo Where userId = ?",
                new Object[]{userId});
        return user_List;

    }

    //根据上传人编号取到所有视频列表
    public List<VideoInfo> ShowVideoList(int userId){
        return executeQuery("Select * From VideoInfo Where userId = ?",
                new Object[]{userId});
    }

    public List<VideoInfo> ShowVideoListFromMOHU(String videoName){
        return executeQuery("Select * From VideoInfo Where videoName LIKE ?",
                new Object[]{"%" + videoName + "%"});
    }

    public static void main(String[] args){


    }
}