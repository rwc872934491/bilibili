package org.lanqiao.servlet;

import org.lanqiao.dao.VideoInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClickAddServlet")
public class ClickAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传来videoId并转化为int
        String videoId = request.getParameter("videoId");
        int videoIdInt = 0;
        if(videoId != null && videoId != "")
            videoIdInt = Integer.parseInt(videoId);
        System.out.println("VideoId :" + videoIdInt);

        //实例化实现类并调用方法,根据视频编号增加点击量
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        int ret = videoInfoDao.ClickVideo(videoIdInt);
        System.out.println("是否增加点击量 :" + ret);

        //将ret返回前端
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
