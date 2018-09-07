package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.VideoInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowTouGaoList")
public class ShowTouGaoListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端拿到userId并转化为int
        String userId = request.getParameter("userId");
        int userIdInt = 0;
        if(userId != null && userId != "")
            userIdInt = Integer.parseInt(userId);
        System.out.println("UserId(ShowTouGaoList) :" + userIdInt);

        //通过投稿者Id找到其投稿的视频列表
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.ShowVideoList(userIdInt);
        System.out.println("List(ShowTouGaoList) :" + list.size());

        //把list传回前端
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
