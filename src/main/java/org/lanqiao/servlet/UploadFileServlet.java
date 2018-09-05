package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.lanqiao.util.UploadFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by David on 2018/8/28.
 */
@WebServlet("/uploadFile")
public class UploadFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * 上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        List<String> fileSrcList = UploadFile.upload(request);

        System.out.println("fileSrcList:" + fileSrcList);

        String videoPath = fileSrcList.get(0);
        System.out.println("videoPath:" + videoPath);
        HttpSession session = request.getSession();
        session.setAttribute("videoPath", videoPath);



        //String typePath=upload(request.getContextPath().getRealPath("/")+fileSrcList[])
        // ReadVideo.readVideoTime(request.getServletContext().getRealPath("/")+fileSrcList.get(0));//获得影片时长
        //实例化实现类

        JSONObject obj = new JSONObject();
        obj.put("errno",0);
        obj.put("data", JSONArray.fromObject(fileSrcList));
        System.out.println("obj.toString:" + obj.toString());
        response.getWriter().print(obj.toString());

    }
}

