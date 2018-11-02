package com.nstr.data.collection.exception;

import com.nstr.data.collection.model.response.APIResponse;
import com.nstr.data.collection.model.response.Message;
import com.nstr.data.collection.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultGlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(DefaultGlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mv = new ModelAndView();
        /*	使用response返回	*/
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(JSONUtil.obj2String(APIResponse.fail(Message.error(ex.getMessage()))));
        } catch (IOException e) {
            logger.error("与客户端通讯异常:"+ e.getMessage(), e);
        }

        logger.debug("异常:" + ex.getMessage(), ex);
        return mv;

    }
}
