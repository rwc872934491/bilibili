package org.lanqiao.servlet;

import org.lanqiao.dao.ReviewInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowCount")
public class ShowCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        int videoid = (int) session.getAttribute("videoId");
        int videoid = 39;

        ReviewInfoDaoImpl reviewInfoDaoImpl = new ReviewInfoDaoImpl();
        int count = reviewInfoDaoImpl.ReviewCount(videoid);
        PrintWriter out = response.getWriter();
        out.print(count);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
