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

@WebServlet("/ShowFirstMenuServlet")
public class ShowFirstMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeInfoDaoImpl typeInfo = new TypeInfoDaoImpl();
        List<TypeInfo> list = new ArrayList <TypeInfo>();
        list = typeInfo.getFirstMenuTypeName();
//        System.out.println(list.size());
////        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i).getTypeId() + " " + list.get(i).getTypeName()
//            + " " + list.get(i).getTypeFather());
//        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }


}
