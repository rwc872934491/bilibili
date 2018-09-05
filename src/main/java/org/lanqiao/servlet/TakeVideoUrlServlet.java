package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TakeVideoUrl")
public class TakeVideoUrlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前端传入videoId并转化为int
        String videoId = request.getParameter("videoId");
        int videoIdInt = 0;
        if(videoId != null && videoId != "")
            videoIdInt = Integer.parseInt(videoId);

        //实例化Session,并用videoId封装他
        HttpSession session = request.getSession();
        session.setAttribute("videoId", videoIdInt);

        System.out.println((int)session.getAttribute("videoId"));

        //将ret传回前端
        int ret = (int)session.getAttribute("videoId");
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
