package org.lanqiao.servlet;

import org.lanqiao.entity.UserInfo;
import org.lanqiao.dao.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InsertUser")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取表单数据
        response.setContentType("utf-8");
        String userName=request.getParameter("phone");
        String nickName=request.getParameter("nickName");
        String password=request.getParameter("password");
        UserInfo userInfo=new UserInfo(userName,nickName,password);
        int ret=new UserInfoDaoImpl().insertUser(userInfo);
        System.out.println(userInfo.getPassword());
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
