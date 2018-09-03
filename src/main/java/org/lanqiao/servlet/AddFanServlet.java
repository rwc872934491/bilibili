package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import netscape.javascript.JSObject;
import org.lanqiao.dao.FanInfoDaoImpl;
import org.lanqiao.entity.FanInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddFan")
public class AddFanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将userId1和userId2传进来
        String userId1 = request.getParameter("userId1");
        String userId2 = request.getParameter("userId2");

        //当userId1和userId2不为空时,转化为Int类型
        int userIdInt1 = 0;
        int userIdInt2 = 0;
        if(userId1 != null && userId1 != "") {
            userIdInt1 = Integer.parseInt(userId1);
            userIdInt2 = Integer.parseInt(userId2);
        }

        //实例化实现类对象和实体类对象
        FanInfoDaoImpl fanInfoDao = new FanInfoDaoImpl();
        FanInfo fanInfo = new FanInfo(userIdInt1, userIdInt2);

        //调用增加粉丝的方法,并返回ret
        int ret = fanInfoDao.AddFanInfo(fanInfo);
        System.out.println("ret in Servlet :" + ret);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
