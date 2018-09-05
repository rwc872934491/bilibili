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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/IndexCheckServlet")
public class IndexCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId1 = (int) session.getAttribute("userId");
        System.out.println(userId1);
        if (userId1 != 0){
            UserInfoDao infodao = new UserInfoDaoImpl();
            List<UserInfo> list = infodao.showUserInfo(userId1);
            JSONArray jsonArray = JSONArray.fromObject(list);
            System.out.println(jsonArray);
            PrintWriter out = response.getWriter();
            out.print(jsonArray);
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
