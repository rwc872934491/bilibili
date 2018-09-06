package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.VideoInfoDao;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.UserInfo;

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

@WebServlet("/ShowVideoUser")
public class ShowVideoUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实例化Session,通过Session找到videoId
        HttpSession session = request.getSession();
        int videoId = (int)session.getAttribute("videoId");

        //通过视频编号,找到其发送者的对象
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<UserInfo> list = new ArrayList<UserInfo>();
        list = videoInfoDao.ShowVideoUser(videoId);

        //将list传回前端
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println("cccccccccccccc"+jsonArray);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
