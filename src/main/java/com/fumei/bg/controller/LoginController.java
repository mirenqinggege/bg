package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.config.Global;
import com.fumei.bg.domain.system.SysUser;
import com.fumei.bg.service.system.ISysUserService;
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
    private final ISysUserService userService;
    private final RedisCache redisCache;
    private final String tokenHeader = Global.getConfig("Token.header");
    private final Integer expiry = Integer.parseInt(Global.getConfig("Token.expireTime")) / 1000;

    public LoginController(ISysUserService userService, RedisCache redisCache) {
        this.userService = userService;
        this.redisCache = redisCache;
    }

    @PostMapping("/login")
    public AjaxResult login(@RequestBody SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
        String captcha = (String) sysUser.getParams().get("captcha");
        String uuid = request.getHeader("uuid");
        String captchaCache = redisCache.getCacheObject(RandomValidateCode.CAPTCHA_PREFIX + uuid);
        if(captchaCache == null){
            return error(AjaxResult.CAPTCHA_ERROR_CODE, "验证码失效");
        }
        if(captcha == null || !captcha.equals(captchaCache)){
            return error(AjaxResult.CAPTCHA_ERROR_CODE, AjaxResult.CAPTCHA_ERROR_MESSAGE);
        }
        SysUser loginSysUser;
        String loginName = sysUser.getLoginName();
        if (RegularUtil.isEmail(loginName)) {
            loginSysUser = userService.getUserByEmail(loginName);
        } else if (RegularUtil.isPhoneNumber(loginName)) {
            loginSysUser = userService.getUserByNumber(loginName);
        } else {
            loginSysUser = userService.getUserByLoginName(loginName);
        }

        if (loginSysUser == null) {
            return error(AjaxResult.USERNAME_NOT_EXIST_CODE, AjaxResult.USERNAME_NOT_EXIST_MESSAGE);
        }
        if (loginSysUser.getStatus() != 0L) {
            return error(AjaxResult.USER_LOGIN_ERROR_CODE, AjaxResult.USER_LOGIN_ERROR_MESSAGE);
        }
        sysUser.setSalt(loginSysUser.getSalt());
        sysUser.setLoginName(loginSysUser.getLoginName());
        MD5Util.passwordEncoding(sysUser);
        if (sysUser.getPassword().equals(loginSysUser.getPassword())) {
            String sign = JWTUtil.sign(loginSysUser.getUserId());
            return success("登陆成功", sign);
        }
        return error(AjaxResult.PASSWORD_VALIDATE_FAIL_CODE, AjaxResult.PASSWORD_VALIDATE_FAIL_MESSAGE);
    }

    @PostMapping("/reg")
    public AjaxResult regUser(@RequestBody SysUser sysUser) {
        MD5Util.passwordEncoding(sysUser);
        if (sysUser.getNumber() != null && !userService.uniqueNumber(sysUser)) {
            return error(AjaxResult.USER_NUMBER_EXITS_CODE, AjaxResult.USER_NUMBER_EXITS_MESSAGE);
        }
        if (sysUser.geteMail() != null && !userService.uniqueEmail(sysUser)) {
            return error(AjaxResult.USER_EMAIL_EXITS_CODE, AjaxResult.USER_EMAIL_EXITS_MESSAGE);
        }
        return toAjax(userService.save(sysUser));
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
