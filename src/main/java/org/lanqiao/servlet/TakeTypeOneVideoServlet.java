package org.lanqiao.servlet;

import org.lanqiao.dao.TypeInfoDaoImpl;
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

@WebServlet("/TakeTypeOneVideo")
public class TakeTypeOneVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传回typeName
        String typeName = request.getParameter("typeName");

        //通过typeName找到typeId
        TypeInfoDaoImpl typeInfoDao = new TypeInfoDaoImpl();
        int typeId = typeInfoDao.ShowTypeId(typeName);
        System.out.println("typeId :" + typeId);

        //通过一级菜单编号找到视频列表
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.ShowTypeOneVideo(typeId);

        //创建并封装session
        HttpSession session = request.getSession();
        for (int i = 0; i < list.size(); i++){
            session.setAttribute("TwoVideo" + i, list.get(i));
        }
        session.setAttribute("TwoVideoLength", list.size());
        System.out.println("List.Size(TakeTypeOneVideoServlet) :" + list.size());

        //将ret传回前端
        int ret = 1;
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
