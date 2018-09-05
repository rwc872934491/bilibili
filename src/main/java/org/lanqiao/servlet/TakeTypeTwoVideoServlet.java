package org.lanqiao.servlet;

import org.lanqiao.dao.FanInfoDaoImpl;
import org.lanqiao.dao.TypeInfoDaoImpl;
import org.lanqiao.dao.VideoInfoDao;
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

@WebServlet("/TakeTypeVideo")
public class TakeTypeTwoVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传回typetwo
        String typeName = request.getParameter("typeName");

        //通过typeName找到typeId
        TypeInfoDaoImpl typeInfoDao = new TypeInfoDaoImpl();
        int typeId = typeInfoDao.ShowTypeId(typeName);
        System.out.println("typeId :" + typeId);

        //通过二级菜单的typeId找到所有视频
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.ShowTypeTwoVideo(typeId);
        System.out.println("List Size() :" + list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getVideoId() + " " + list.get(i).getVideoName());
        }

        //创建并封装session
        HttpSession session = request.getSession();
        for (int i = 0; i < list.size(); i++){
            session.setAttribute("TwoVideo" + i, list.get(i));
        }
        session.setAttribute("TwoVideoLength", list.size());
        for(int i = 0; i < list.size(); i++){
            VideoInfo videoInfo = new VideoInfo();
            videoInfo = (VideoInfo) session.getAttribute("TwoVideo" + i);
            System.out.println("TwoVideo" + i + ": " + videoInfo.getVideoId());
        }

        //将ret返回前端
        int ret = list.size();
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
