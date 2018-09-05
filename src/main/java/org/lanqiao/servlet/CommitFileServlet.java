package org.lanqiao.servlet;

import net.sf.json.JSONObject;
import org.lanqiao.dao.VideoInfoDao;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.entity.VideoInfo;
import org.lanqiao.util.UploadPic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CommitFileServlet")
public class CommitFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoName=request.getParameter("videoName");
        String typeId=request.getParameter("typeId");
        String videoPath;
        String videoImage;
        int userId;

        HttpSession session = request.getSession();
        videoImage = (String) session.getAttribute("videoImage");
        videoPath = (String) session.getAttribute("videoPath");
        userId = (int) session.getAttribute("userId");
        System.out.println(videoImage);
        int typeIdInt = 0;
        if(typeId != null && typeId != "") {
            typeIdInt = Integer.parseInt(typeId);
        }

        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoName(videoName);
        videoInfo.setVideoType(typeIdInt);
        videoInfo.setUserId(userId);
        videoInfo.setVideoImage(videoImage);
        videoInfo.setVideoPath(videoPath);
        VideoInfoDaoImpl videoInfoDao = new VideoInfoDaoImpl();
        int ret = videoInfoDao.InsertVideoInfo(videoInfo);

        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();




    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
