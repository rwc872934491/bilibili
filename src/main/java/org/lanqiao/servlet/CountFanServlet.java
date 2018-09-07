package org.lanqiao.servlet;

import org.lanqiao.dao.FanInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CountFan")
public class CountFanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端里取到userId
        String userId = request.getParameter("userId");
        int userIdInt = 0;
        if(userId != null && userId != "")
            userIdInt = Integer.parseInt(userId);
        System.out.println("UserId(CountFan) :" + userIdInt);

        //通过userId找到其粉丝数
        FanInfoDaoImpl fanInfoDao = new FanInfoDaoImpl();
        int ret = fanInfoDao.CountFan(userIdInt);
        System.out.println("Ret(CountFan) :" + ret);

        //传回ret
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
