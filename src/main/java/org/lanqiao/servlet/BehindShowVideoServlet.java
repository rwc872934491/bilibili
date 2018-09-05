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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/BehindShowVideo")
public class BehindShowVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传值并转化为int类型
        String pageNum = request.getParameter("pageNum");
        int pageNumInt = 0;
        if(pageNum != null && pageNum != "")
            pageNumInt = Integer.parseInt(pageNum);

        //实例化实现类并调用方法
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.ShowVideoInfo(pageNumInt, 8);
        System.out.println(list.size());

        //将list传回前端
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        System.out.println("JsonArray :" + jsonArray);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
