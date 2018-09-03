package org.lanqiao.servlet;

import net.sf.json.JsonConfig;
import org.lanqiao.dao.UserInfoDaoImpl;
import org.lanqiao.entity.UserInfo;
import net.sf.json.JSONArray;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/BehindShowUser")
public class BehindShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //传入pageNum并转化为int
        String pageNum = request.getParameter("pageNum");
        int pageNumInt = 0;
        if(pageNum != null && pageNum != "")
            pageNumInt = Integer.parseInt(pageNum);

        //实例化实现类
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();

        //调用方法
        List<UserInfo> list = new ArrayList<UserInfo>();
        list = userInfoDao.showUserInfo(pageNumInt, 8);
        System.out.println("List.Size() :" + list.size());

        //将结果集传回前端
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
