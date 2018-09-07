package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import netscape.javascript.JSObject;
import org.lanqiao.dao.FanInfoDaoImpl;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.FanInfo;
import org.lanqiao.entity.VideoInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddFan")
public class AddFanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实例化Session,从session中取登录的Id即userId,以及此视频的Id即videoId
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        int videoId = (int) session.getAttribute("videoId");
        System.out.println("UserId(AddFan) :" + userId);
        System.out.println("VideoId(AddFan) :" + videoId);

        //实例化实现类,
        //根据视频编号找到用户编号
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = videoInfoDao.GetVedioInfo(videoId);
        System.out.println("List.Size(AddFan) :" + list.size());
        int userId2 = list.get(0).getUserId();

        //通过两个用户编号判断此条记录是否存在
        FanInfoDaoImpl fanInfoDao = new FanInfoDaoImpl();
        int flag = fanInfoDao.ExsistFaninfo(userId2, userId);
        System.out.println("Flag(AddFan) :" + flag);

        //如果此条记录不存在,加粉丝关系,即关注
        int ret;
        if(flag == 0){
            //根据两个用户编号封装FanInfo建立主人粉丝关系
            FanInfo fanInfo = new FanInfo(userId2, userId);
            fanInfoDao.AddFanInfo(fanInfo);
            ret = 0;
        }else{
            ////根据两人编号删除这条记录(要求这两人的记录确实存在)
            fanInfoDao.DeleteFaninfo(userId2, userId);
            ret = 1;
        }
        System.out.println("Ret(AddFan) :" + ret);

        //将ret返回前端
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
