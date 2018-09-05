package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.VideoInfo;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/SetVideoUrl")
public class SetVideoUrlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实例化Session,得到videoId
        HttpSession session = request.getSession();
        int videoId = (int)session.getAttribute("videoId");
        System.out.println("VideoId :" + videoId);

        //实例化实现类并调用方法得到VideoInfo对象
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.GetVedioInfo(videoId);
        for (int i = 0; i < list.size(); i++){
            System.out.println("Video : " + list.get(i).getVideoId() + " " + list.get(i).getVideoName() + " " + list.get(i).getVideoPath());
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        //将videoId返回前端
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        System.out.println(jsonArray);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
