package org.lanqiao.servlet;

import com.sun.prism.j2d.print.J2DPrinterJob;
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

@WebServlet("/ShowFenSi")
public class ShowFenSiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从Session中取出userId
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");
        System.out.println("UserId(ShowFenSi) :" + userId);

        //通过userId找到其粉丝的用户信息
        List<UserInfo> list = new ArrayList<UserInfo>();
        FanInfoDaoImpl fanInfoDao = new FanInfoDaoImpl();
        list = fanInfoDao.ShowFanInfo(userId);
        System.out.println("List.Size(ShowFenSi) :" + list.size());

        //将List传回前端
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
