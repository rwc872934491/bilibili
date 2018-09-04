package org.lanqiao.miaodiyun.huiDiao;

import org.lanqiao.miaodiyun.httpApiDemo.IndustrySMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("str");
        String backCode= IndustrySMS.code;
        if(code.equals(backCode)) {
            PrintWriter out=response.getWriter();
            out.print('1');
            out.flush();
            out.close();
        }else {
            PrintWriter out=response.getWriter();
            out.print('0');
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
