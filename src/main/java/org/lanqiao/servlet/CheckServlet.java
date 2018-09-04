package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.UserInfoDao;
import org.lanqiao.dao.UserInfoDaoImpl;
import org.lanqiao.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Check")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取表单元素,
        HttpSession session = request.getSession();
        //从前端传入username和password
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //封装实现类和实体类并调用方法
        UserInfo userInfo = new UserInfo(userName, password);
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        List<UserInfo> list = new ArrayList<UserInfo>();
        list = userInfoDao.checkUser(userInfo);
        System.out.println("List Size() :" + list.size());
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(0).getUserId() + list.get(0).getUserName() + " "
                    + list.get(0).getPassword() + " " + list.get(0).getUserLocked());
        }

        //判断各种登陆状况
        int ret = 0;
        if(list.size() > 0){
            if(list.get(0).getUserName().equals(userName) && list.get(0).getPassword().equals(password)) {
                Date now = new Date();
                if(list.get(0).getUserLocked().getTime() - now.getTime() > 0 || list.get(0).getUserLocked() == null)
                    ret = 2;
                else{
                    if(list.get(0).getUserIdentity() == 0)
                        ret = 3;
                    else
                        ret = 4;
                }

            }
            else{
                ret = 1;
            }
        }else {
            ret = 1;
        }
        UserInfo user = userInfoDao.getUserInfo(userName);
        int userId = user.getUserId();
        String userImage = user.getUserImage();
        session.setAttribute("userId", userId);
        session.setAttribute("userName", userName);
        session.setAttribute("Password", password);
        session.setAttribute("userImage", userImage);
        PrintWriter out=response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
