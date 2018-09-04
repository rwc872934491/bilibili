package org.lanqiao.servlet;

import org.lanqiao.dao.ReviewInfoDaoImpl;
import org.lanqiao.entity.ReviewInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddBack")
public class AddBackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userid = (int) session.getAttribute("userId");
        int videoID = Integer.parseInt(request.getParameter("VedioID"));
        String reviewContent = request.getParameter("ReviewContent");
        int reviewTop = Integer.parseInt(request.getParameter("TopReviewID"));

        ReviewInfo reviewInfo = new ReviewInfo(userid,videoID,reviewContent,reviewTop);
        int ret = new ReviewInfoDaoImpl().AddBackReview(reviewInfo);
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
