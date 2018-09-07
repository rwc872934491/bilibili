package org.lanqiao.servlet;

import net.sf.json.JSONArray;
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

@WebServlet("/TuiJian")
public class TuiJianServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从Session中取videoId
        HttpSession session = request.getSession();
        int videoId = (int)session.getAttribute("videoId");
        System.out.println("VideoId(TuiJian) :" + videoId);

        //从视频编号找到整个对象,来得到videoType
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list_first = new ArrayList<VideoInfo>();
        list_first = videoInfoDao.ClickShow(videoId);
        int typeId = list_first.get(0).getVideoType();
        System.out.println("TypeId(TuiJian) :" + typeId);

        //根据二级菜单编号显示所有视频
        List<VideoInfo> list_final = new ArrayList<VideoInfo>();
        list_final = videoInfoDao.ShowTypeTwoVideo(typeId);
        System.out.println("List.Size(TuiJian) :" + list_final);

        //将list传回前端
        JSONArray jsonArray = JSONArray.fromObject(list_final);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
