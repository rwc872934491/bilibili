package org.lanqiao.servlet;

import org.lanqiao.dao.ReviewInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowCount")
public class ShowCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewInfoDaoImpl reviewInfoDaoImpl = new ReviewInfoDaoImpl();
        int count = reviewInfoDaoImpl.ReviewCount();
        PrintWriter out = response.getWriter();
        out.print(count);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
