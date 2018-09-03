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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Check")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取表单元素,
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        UserInfo userInfo = new UserInfo(userName, password);
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        UserInfo ret = userInfoDao.checkUser(userInfo);
//        UserInfo ret=new UserInfoDaoImpl().checkUser(userInfo) ;
        if (ret != null) {
            UserInfo user = userInfoDao.getUserInfo(userName);
            int userId = user.getUserId();
            String userImage = user.getUserImage();
            session.setAttribute("userId", userId);
            session.setAttribute("userName", userName);
            session.setAttribute("Password", password);
            session.setAttribute("userImage", userImage);
            response.getWriter().print(1);
        } else {
            response.getWriter().print(0);
        }

//        PrintWriter out=response.getWriter();
//        out.print(JSONArray.fromObject(ret));
//        out.flush();
//        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
