package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.ReviewInfoDaoImpl;
import org.lanqiao.dao.UserInfoAndReviewInfoDaoImpl;
import org.lanqiao.entity.ReviewInfo;
import org.lanqiao.entity.UserInfoAndReviewInfo;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/ShowBack")
public class ShowBackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int num = Integer.parseInt(request.getParameter("nums"));
        int userid = Integer.parseInt(request.getParameter("reviewid"));

        List<UserInfoAndReviewInfo> list = new UserInfoAndReviewInfoDaoImpl().ShowUserBack(userid,1,4);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        System.out.println(jsonArray);
        PrintWriter out=response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
