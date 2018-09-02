package org.lanqiao.servlet;

import org.lanqiao.dao.ReviewInfoDaoImpl;
import org.lanqiao.entity.ReviewInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddReview")
public class AddReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("UserID"));
        int videoid = Integer.parseInt(request.getParameter("VedioID"));
        String reviewContent = request.getParameter("ReviewContent");
        int reviewTop = Integer.parseInt(request.getParameter("TopReviewID"));
        int reviewFloor = Integer.parseInt(request.getParameter("FooterID"));

        ReviewInfo review = new ReviewInfo(userid,videoid,reviewContent,reviewTop,reviewFloor);
        int ret = new ReviewInfoDaoImpl().AddReview(review);
        System.out.println(ret);
        request.getSession().setAttribute("ret",ret);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
