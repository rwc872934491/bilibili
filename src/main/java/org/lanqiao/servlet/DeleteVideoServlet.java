package org.lanqiao.servlet;

import org.lanqiao.dao.VideoInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteVideo")
public class DeleteVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传videoId并转化为int类型
        String videoId = request.getParameter("videoId");
        int videoIdInt = 0;
        if(videoId != null && videoId != "")
            videoIdInt = Integer.parseInt(videoId);

        //实例化实现类并调用方法
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        int ret = videoInfoDao.DeleteVideo(videoIdInt);

        //将ret传回前端
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
