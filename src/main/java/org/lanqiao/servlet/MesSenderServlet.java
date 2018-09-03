package org.lanqiao.servlet;

import org.lanqiao.dao.MsgInfoDaoImpl;
import org.lanqiao.entity.MsgInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MesSender")
public class MesSenderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("utf-8");
        String msgContent=request.getParameter("msgContent");
        int msgSender= Integer.parseInt(request.getParameter("msgSender"));
        int msgReceiver= Integer.parseInt(request.getParameter("msgReceiver"));
        MsgInfo msgInfo=new MsgInfo(msgContent,msgSender,msgReceiver);
        int ret=new MsgInfoDaoImpl().addUserMsg(msgInfo);
        request.getSession().setAttribute("ret",ret);
//        response.sendRedirect("/MsgReceiver");
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
