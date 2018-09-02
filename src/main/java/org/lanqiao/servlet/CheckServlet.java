package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.UserInfoDaoImpl;
import org.lanqiao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Check")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取表单元素,
        HttpSession session=request.getSession();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        UserInfo userInfo=new UserInfo(userName,password);
        UserInfo ret=new UserInfoDaoImpl().checkUser(userInfo) ;
        if(ret!=null){
            JSONArray user = JSONArray.fromObject(session.getAttribute("userBean"));
            response.getWriter().print(1);
        }else{
            response.getWriter().print(0);
        }

//        PrintWriter out=response.getWriter();
//        out.print(JSONArray.fromObject(ret));
//        out.flush();
//        out.close();
    }
}
