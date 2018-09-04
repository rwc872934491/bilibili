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

@WebServlet("/ShowMaxFloor")
public class ShowMaxFloorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int videoid = 39;
        HttpSession session = request.getSession();
//        int videoid = (int) session.getAttribute("videoId");
        ReviewInfoDaoImpl review = new ReviewInfoDaoImpl();
        int MaxFloor = review.MaxFloor(videoid);
        System.out.println("最大楼层"+MaxFloor);

        PrintWriter out = response.getWriter();
        out.print(MaxFloor);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
