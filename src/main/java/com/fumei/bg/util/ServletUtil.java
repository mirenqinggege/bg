package com.fumei.bg.util;

import com.fumei.bg.common.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zkh
 */
public class ServletUtil {
    private static final Logger log = LoggerFactory.getLogger(ServletUtil.class);
    public static void responseAjaxResult(HttpServletResponse response, AjaxResult ajaxResult){
        try {
            response.getWriter().write(JsonUtil.objectToJson(ajaxResult));
        } catch (Exception e) {
            log.error("向浏览器响应时异常", e);
        }
    }
}
