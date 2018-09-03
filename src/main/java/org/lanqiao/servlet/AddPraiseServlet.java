package org.lanqiao.servlet;

import org.lanqiao.dao.ReviewInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddPraise")
public class AddPraiseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传值并转化为int类型
        String reviewId = request.getParameter("reviewId");
        int reviewIdInt = 0;
        if(reviewId != null && reviewId != "")
            reviewIdInt = Integer.parseInt(reviewId);
        System.out.println(reviewIdInt);

        //实例化实现类
        ReviewInfoDaoImpl reviewInfoDao = new ReviewInfoDaoImpl();
        int ret = reviewInfoDao.AddTrueReview(reviewIdInt);
        System.out.println("ret:" + ret);

        //把值传回Ajax
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
