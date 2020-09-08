package com.fumei.bg.common;

import com.fumei.bg.util.JsonUtil;
import com.fumei.bg.util.RandomValidateCode;
import com.fumei.bg.util.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zkh
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController extends BaseController{
    private static final Logger log = LoggerFactory.getLogger(CaptchaController.class);
    private final RedisCache redisCache;

    public CaptchaController(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    @GetMapping("")
    public void getCaptcha(Integer width, Integer height, HttpServletResponse response){
        if (width != null && height != null) {
            RandomValidateCode code = new RandomValidateCode();
            code.getRandCode(width,height,response);
        } else {
            try {
                response.getWriter().write(JsonUtil.objectToJson(error(AjaxResult.REQUEST_PARAMS_ERROR_CODE, AjaxResult.REQUEST_PARAMS_ERROR_MESSAGE)));
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
