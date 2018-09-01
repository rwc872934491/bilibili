package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.UserInfoDao;
import org.lanqiao.dao.UserInfoDaoImpl;
import org.lanqiao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showUserInfoServlet")
public class showUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = 2;
        //3.dao操作
        UserInfoDao infodao = new UserInfoDaoImpl();
        List<UserInfo> list = infodao.showUserInfo(userId);
        System.out.println(list.size());
        //Json
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
