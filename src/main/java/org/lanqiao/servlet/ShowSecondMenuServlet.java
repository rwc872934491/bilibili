package org.lanqiao.servlet;

import org.lanqiao.dao.TypeInfoDaoImpl;
import org.lanqiao.entity.TypeInfo;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowSecondMenuServlet")
public class ShowSecondMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String typeid = request.getParameter("typeId");
       // System.out.println("传过来的值是" + typeid);
        int typeidInt = 0;
        if(typeid != null && typeid != "") {
            typeidInt = Integer.parseInt(typeid);
            //System.out.println("传过来的值变成" + typeidInt);
        }
        TypeInfoDaoImpl typeInfo = new TypeInfoDaoImpl();
        List<TypeInfo> list = new ArrayList <TypeInfo>();
        list = typeInfo.getSecondMenuTypeName(typeidInt);
        System.out.println(list.size());
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i).getTypeName());
//        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }


}
