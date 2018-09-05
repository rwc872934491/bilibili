package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.TypeInfoDaoImpl;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.TypeInfo;
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

@WebServlet("/ShowSecond")
public class ShowSecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实例化Session,取出videoId
        HttpSession session = request.getSession();
        int videoId = (int)session.getAttribute("videoId");
        System.out.println("VideoId(ShowSecond) :" + videoId);

        //通过视频编号找视频对象,从而找二级菜单编号
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.ClickShow(videoId);
        int typeId = list.get(0).getVideoType();
        System.out.println("TypeId(ShowSecond) :" + typeId);

        //通过二级菜单编号找到二级菜单对象
        TypeInfoDaoImpl typeInfoDao = new TypeInfoDaoImpl();
        List<TypeInfo> list1 = new ArrayList<TypeInfo>();
        list1 = typeInfoDao.ShowSecondMenu(typeId);
        System.out.println("List(ShowSecond) :" + list1.get(0).getTypeName());

        //将list传回前端
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
