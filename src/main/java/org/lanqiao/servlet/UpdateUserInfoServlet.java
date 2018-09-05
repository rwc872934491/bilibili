package org.lanqiao.servlet;

import org.lanqiao.dao.UserInfoDao;
import org.lanqiao.dao.UserInfoDaoImpl;
import org.lanqiao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获得表单数据
        String nickname = request.getParameter("nickname");
        String userMark = request.getParameter("userMark");
        String userSex = request.getParameter("userSex");
        System.out.println(nickname);
        System.out.println(userMark);
        System.out.println(userSex);
        HttpSession session = request.getSession();
        int userId =(int)session.getAttribute("userId");
        //2.封装对象
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setNickname(nickname);
        userInfo.setUserMark(userMark);
        userInfo.setUserSex(userSex);
        //3.dao操作
        UserInfoDao dao = new UserInfoDaoImpl();
        int ret = dao.updateUserInfo(userInfo);
        //4.输出结果
        System.out.println(ret);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
