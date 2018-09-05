package org.lanqiao.servlet;


import net.sf.json.JSONObject;
import org.lanqiao.dao.UserInfoDao;
import org.lanqiao.dao.UserInfoDaoImpl;
import org.lanqiao.dao.VideoInfoDao;
import org.lanqiao.dao.VideoInfoDaoImpl;
import org.lanqiao.util.UploadPic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/VideoFaceServlet")
public class VideoFaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111111111111111111");

        String img = request.getParameter("img");
        String imgName = UploadPic.upload(img,request.getServletContext().getRealPath("/") + "upload/");
        String videoImage = "/upload/" + imgName;

        HttpSession session = request.getSession();
        session.setAttribute("videoImage", videoImage);
        System.out.println(videoImage);

        JSONObject jsonObj = new  JSONObject();
        jsonObj.accumulate("imgUrl", "/upload/"+imgName);
        response.getWriter().print(jsonObj.toString());




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
