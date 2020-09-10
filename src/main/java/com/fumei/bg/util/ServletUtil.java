package com.fumei.bg.util;

import com.fumei.bg.common.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zkh
 */
public class ServletUtil {
    private static final Logger log = LoggerFactory.getLogger(ServletUtil.class);
    public static void responseAjaxResult(HttpServletResponse response, AjaxResult ajaxResult){
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(JsonUtil.objectToJson(ajaxResult));
        } catch (Exception e) {
            log.error("向浏览器响应时异常", e);
        }
    }

    public static ServletRequestAttributes getServletAttr(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest(){
        return getServletAttr().getRequest();
    }

    public static HttpServletResponse getResponse(){
        return getServletAttr().getResponse();
    }
}
