package org.lanqiao.util;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadPic {
    public static String upload(String img, String filePath) { // 对字节数组字符串进行Base64解码并生成图片

        //若上传文件夹路径不存在，则创建文件路径
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] pics = img.split(",");// 0为类型 1为数据
        String imgStr = pics[1];// 得到图片数据
        // 得到图片类型
        String imgType = null;
        if (pics[0].indexOf("image/jpeg") > 0) {
            imgType = ".jpg";
        } else if (pics[0].indexOf("image/gif") > 0) {
            imgType = ".gif";
        } else if (pics[0].indexOf("image/png") > 0) {
            imgType = ".png";
        } else {
            System.out.println("图片格式不正确！");
        }

        if (imgStr == null) // 图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 根据时间生成图片名称
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmsssss");
            String imgName = simpleDateFormat.format(new Date()) + imgType;
            String imgFilePath = filePath + imgName;
            System.out.println(imgFilePath);
            // 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return imgName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
