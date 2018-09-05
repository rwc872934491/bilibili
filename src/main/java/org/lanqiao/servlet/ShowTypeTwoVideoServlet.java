package org.lanqiao.servlet;


import com.google.gson.JsonArray;
import org.lanqiao.entity.VideoInfo;
import net.sf.json.JSONArray;
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

@WebServlet("/ShowTypeTwoVideo")
public class ShowTypeTwoVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过Session取得视频列表和列表长度,并封装为list
        HttpSession session = request.getSession();
        int lenth = (int)session.getAttribute("TwoVideoLength");
        System.out.println("Lenth :" + lenth);
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        for (int i = 0; i < lenth; i++){
            VideoInfo videoInfo = new VideoInfo();
            videoInfo = (VideoInfo) session.getAttribute("TwoVideo" + i);
            System.out.println("VedioInfo :" + videoInfo.getVideoId() + " " + videoInfo.getVideoName());
            list.add(videoInfo);
        }

        //将list传回前端
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
