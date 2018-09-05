package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.ReviewInfoDaoImpl;
import org.lanqiao.dao.ReviewReultDaoImpl;
import org.lanqiao.entity.ReviewInfo;
import org.lanqiao.entity.ReviewResult;

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

@WebServlet("/ReviewResultServlet")
public class ReviewResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId1 = (int) session.getAttribute("userId");


        if(userId1!=0) {
            ReviewReultDaoImpl reviewInfo = new ReviewReultDaoImpl();
            List <ReviewResult> list = reviewInfo.ShowData(userId1);
            System.out.println(list);
            JSONArray jsonArray = JSONArray.fromObject(list);
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
