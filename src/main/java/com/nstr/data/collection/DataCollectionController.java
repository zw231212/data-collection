package com.nstr.data.collection;

import com.nstr.data.collection.util.IPAddressUtil;
import com.nstr.data.collection.util.URLUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Controller
@RequestMapping("/data/nstr")    //url尽量短，减少没必要的字符
public class DataCollectionController {

    @RequestMapping(value = "/log.gif")
    public void analysis(String args, HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
		    //打印日志
        System.out.println(args);
        //获取ip信息
        String ipAddr = IPAddressUtil.getIpAddr(request);
        System.out.println(ipAddr);
        //将其他的参数信息解析为map参数
        Map<String, Object> infos = URLUtil.parseArgs(args);
        System.out.println(infos);

        //使用jackson将map转换成bean


        //返回信息
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        OutputStream out = response.getOutputStream();
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(image, "gif", out);
        out.flush();
    }
}
