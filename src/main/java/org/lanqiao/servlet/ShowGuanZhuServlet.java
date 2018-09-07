package org.lanqiao.servlet;

import org.lanqiao.dao.FanInfoDaoImpl;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.VideoInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowGuanZhu")
public class ShowGuanZhuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实例化Session,从session中取登录的Id即userId,以及此视频的Id即videoId
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        int videoId = (int) session.getAttribute("videoId");
        System.out.println("UserId(ShowGuanZhu) :" + userId);
        System.out.println("VideoId(ShowGuanZhu) :" + videoId);

        //实例化实现类,
        //根据视频编号找到用户编号
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.GetVedioInfo(videoId);
        System.out.println("List.Size(ShowGuanZhu) :" + list.size());
        int userId2 = list.get(0).getUserId();

        //通过两个用户编号判断此条记录是否存在
        FanInfoDaoImpl fanInfoDao = new FanInfoDaoImpl();
        int flag = fanInfoDao.ExsistFaninfo(userId2, userId);
        System.out.println("Flag(ShowGuanZhu) :" + flag);

        //将flag返回前端
        PrintWriter out = response.getWriter();
        out.print(flag);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
