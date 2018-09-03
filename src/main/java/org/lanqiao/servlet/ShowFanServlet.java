package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.FanInfoDaoImpl;
import org.lanqiao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowFan")
public class ShowFanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过session取userId
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");

        //实例化实现类
        FanInfoDaoImpl fanInfoDao = new FanInfoDaoImpl();
        List<UserInfo> list = new ArrayList<UserInfo>();
        list = fanInfoDao.ShowFanInfo(userId);

        //通过Json传回前端
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
