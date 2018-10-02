package com.nstr.data.collection;

import com.nstr.data.collection.model.CollectionData;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.util.IPAddressUtil;
import com.nstr.data.collection.util.JSONUtil;
import com.nstr.data.collection.util.URLUtil;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/nstr/data")    //url尽量短，减少没必要的字符
public class DataCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(DataCollectionController.class);

    @Autowired
    private ResourceCommentService resourceCommentService;

    @RequestMapping(value = "/log.gif")
    public void analysis(String args, HttpServletRequest request,
                         @RequestParam(value = "type",required = false,defaultValue = "geoip") String type,
                         HttpServletResponse response) throws IOException {
		    //打印日志
        //获取ip信息
        String ipAddr = IPAddressUtil.getIpAddr(request);
        logger.info("数据请求：from: "+ipAddr+" , args:"+args);
        //将其他的参数信息解析为map参数
        Map<String, Object> infos = URLUtil.parseArgs(args);
        //使用jackson将map转换成bean
        CollectionData cdata = null;
        try {
            cdata = JSONUtil.map2pojo(infos, CollectionData.class);
        } catch (Exception e){
          //转换发生异常，那就一个个设置?
            e.printStackTrace();
        }

        System.out.println(cdata);

        if(cdata != null ){
            System.out.println("===================================================");
            cdata.setIpaddr(ipAddr);
            //保存信息
            ResourceComment rc = resourceCommentService.save(cdata, type);
            System.out.println(rc);
        }

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
