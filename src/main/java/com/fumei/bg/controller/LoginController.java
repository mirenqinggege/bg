package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.config.Global;
import com.fumei.bg.domain.User;
import com.fumei.bg.service.IUserService;
import com.fumei.bg.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zkh
 */
@RestController
public class LoginController extends BaseController {
    private final IUserService userService;
    private final RedisCache redisCache;
    private final String tokenHeader = Global.getConfig("Token.header");
    private final Integer expiry = Integer.parseInt(Global.getConfig("Token.expireTime")) / 1000;

    public LoginController(IUserService userService, RedisCache redisCache) {
        this.userService = userService;
        this.redisCache = redisCache;
    }

    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        String captcha = (String) user.getParams().get("captcha");
        String uuid = request.getHeader("uuid");
        String captchaCache = redisCache.getCacheObject(RandomValidateCode.CAPTCHA_PREFIX + uuid);
        if(captchaCache == null){
            return error(AjaxResult.CAPTCHA_ERROR_CODE, "验证码失效");
        }
        if(captcha == null || !captcha.equals(captchaCache)){
            return error(AjaxResult.CAPTCHA_ERROR_CODE, AjaxResult.CAPTCHA_ERROR_MESSAGE);
        }
        User loginUser;
        String loginName = user.getLoginName();
        if (RegularUtil.isEmail(loginName)) {
            loginUser = userService.getUserByEmail(loginName);
        } else if (RegularUtil.isPhoneNumber(loginName)) {
            loginUser = userService.getUserByNumber(loginName);
        } else {
            loginUser = userService.getUserByLoginName(loginName);
        }

        if (loginUser == null) {
            return error(AjaxResult.USERNAME_NOT_EXIST_CODE, AjaxResult.USERNAME_NOT_EXIST_MESSAGE);
        }
        if (loginUser.getStatus() != 0L) {
            return error(AjaxResult.USER_LOGIN_ERROR_CODE, AjaxResult.USER_LOGIN_ERROR_MESSAGE);
        }
        user.setSalt(loginUser.getSalt());
        user.setLoginName(loginUser.getLoginName());
        MD5Util.passwordEncoding(user);
        if (user.getPassword().equals(loginUser.getPassword())) {
            String sign = JWTUtil.sign(loginUser.getUserId());
            return success("登陆成功", sign);
        }
        return error(AjaxResult.PASSWORD_VALIDATE_FAIL_CODE, AjaxResult.PASSWORD_VALIDATE_FAIL_MESSAGE);
    }

    @PostMapping("/reg")
    public AjaxResult regUser(@RequestBody User user) {
        MD5Util.passwordEncoding(user);
        if (user.getNumber() != null && !userService.uniqueNumber(user)) {
            return error(AjaxResult.USER_NUMBER_EXITS_CODE, AjaxResult.USER_NUMBER_EXITS_MESSAGE);
        }
        if (user.geteMail() != null && !userService.uniqueEmail(user)) {
            return error(AjaxResult.USER_EMAIL_EXITS_CODE, AjaxResult.USER_EMAIL_EXITS_MESSAGE);
        }
        return toAjax(userService.save(user));
    }

    @PostMapping("/logout")
    public AjaxResult logout(HttpServletResponse response) {
        Cookie cookie = new Cookie(tokenHeader,"");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return success("退出成功");
    }

    @PostMapping("/checkToken")
    public AjaxResult checkToken(HttpServletRequest request, HttpServletResponse response){
        if (JWTUtil.validateLogin(request, response)) {
            return success("登录状态正常", true);
        }
        return null;
    }
}
