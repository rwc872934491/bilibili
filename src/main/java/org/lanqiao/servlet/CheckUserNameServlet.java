package org.lanqiao.servlet;

import org.lanqiao.dao.UserInfoDaoImpl;
import org.lanqiao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CheckUserName")
public class CheckUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("efrewertytrewrty");
        String userName=request.getParameter("userName");
        UserInfoDaoImpl userInfoDao=new UserInfoDaoImpl();
        List<UserInfo> list=new ArrayList<UserInfo>();
        list=userInfoDao.CheckUserName(userName);
        PrintWriter out=response.getWriter();
        System.out.println("list.size : " + list.size());
        if(list.size()>0){
            out.print(1);
        }else{
            out.print(0);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
