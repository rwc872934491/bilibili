package org.lanqiao.servlet;

import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.VideoInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TakeMoHuListServlet")
public class TakeMoHuListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传入模糊信息
        String videoName = request.getParameter("videoName");

        //通过模糊信息查到模糊信息视频列表
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.ShowVideoListFromMOHU(videoName);

        //将列表长度和列表内容封装到Session中
        HttpSession session = request.getSession();
        session.setAttribute("TwoVideoLength", list.size());
        System.out.println("List.Size(TakeMoHuList) :" + list.size());
        for (int i = 0; i < list.size(); i++){
            session.setAttribute("TwoVideo" + i, list.get(i));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
