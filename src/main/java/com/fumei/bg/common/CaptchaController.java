package com.fumei.bg.common;

import com.fumei.bg.util.RandomValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zkh
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController extends BaseController{
    private static final Logger log = LoggerFactory.getLogger(CaptchaController.class);

    @GetMapping("")
    public AjaxResult getCaptcha(Integer width, Integer height){
        if (width != null && height != null) {
            RandomValidateCode code = new RandomValidateCode();
            return success("获取验证码成功", code.getRandCode(width, height));
        } else {
            return error(AjaxResult.REQUEST_PARAMS_ERROR_CODE, AjaxResult.REQUEST_PARAMS_ERROR_MESSAGE);
        }
    }
}
