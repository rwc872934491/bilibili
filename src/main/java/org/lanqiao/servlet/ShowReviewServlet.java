package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.UserInfoAndReviewInfoDaoImpl;
import org.lanqiao.entity.UserInfoAndReviewInfo;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/ShowReview")
public class ShowReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = 1;
        int video = 39;
//        int num = 0;
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("page")+"aaaaaaaaaaaaaaaaaa");
        if (session.getAttribute("page")!=null){
          pageNum = (int) session.getAttribute("page");
        }
        System.out.println(pageNum+"!!!!!!!!!!!!!!!!!!!");
        List<UserInfoAndReviewInfo> list = new UserInfoAndReviewInfoDaoImpl().ShowUserReview(video,pageNum,4);

        System.out.println(list);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
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
