package org.lanqiao.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by David on 2018/8/28.
 */
public class UploadFile {

    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    /**
     * @param request    HttpServletRequest对象
     * @param path       图片上传路径，默认为webapp/upload
     * @param dateFormat 是否以日期格式替代文件名，默认为true
     */
    public static List<String> upload(HttpServletRequest request, String path, boolean dateFormat) {
        return doUpload(request, path, dateFormat);
    }

    /**
     * @param request HttpServletRequest对象
     * @param path    图片上传路径，默认为webapp/upload
     */
    public static List<String> upload(HttpServletRequest request, String path) {
        return doUpload(request, path, true);
    }

    /**
     * @param request HttpServletRequest对象
     */
    public static List<String> upload(HttpServletRequest request) {
        return doUpload(request, "upload", true);
    }

    private static List<String> doUpload(HttpServletRequest request, String path, boolean dateFormat) {
        //存放上传多个文件的文件名
        List<String> fileNameList = new ArrayList<String>();
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderEncoding("UTF-8");
        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("/") + path;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        //是否进行日期格式处理
                        String fileName = new File(item.getName()).getName();
                        if (dateFormat) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmsssss");
                            fileName = simpleDateFormat.format(new Date()) + (int) (Math.random() * 1000) + fileName.substring(fileName.lastIndexOf("."));
                        }
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        // 添加文件名到集合
                        fileNameList.add(path + File.separator + fileName);

                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fileNameList;
    }
}
