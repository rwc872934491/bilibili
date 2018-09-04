package org.lanqiao.servlet;

import org.lanqiao.dao.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/LockUser")
public class LockUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //传入userId并转化为int类型
        String userId = request.getParameter("userId");
        int userIdInt = 0;
        if(userId != null && userId != "")
            userIdInt = Integer.parseInt(userId);

        //实例化实现类并调用方法
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        int ret = userInfoDao.ChangeLocked(userIdInt);

        //将ret传回前端
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
