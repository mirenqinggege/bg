package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.User;
import com.fumei.bg.service.IUserService;
import com.fumei.bg.util.MD5Util;
import com.fumei.bg.util.RegularUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zkh
 */
@RestController
public class LoginController extends BaseController {
    private final IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AjaxResult login(User user, HttpServletResponse response) {
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
        MD5Util.passwordEncoding(user);
        if (user.getPassword().equals(loginUser.getPassword())) {
            return success("登陆成功",loginUser);
        }
        return null;
    }

    @PostMapping("/reg")
    public AjaxResult regUser(User user) {
        MD5Util.passwordEncoding(user);
        if (user.getNumber() != null && !userService.uniqueNumber(user)) {
            return error(AjaxResult.USER_NUMBER_EXITS_CODE, AjaxResult.USER_NUMBER_EXITS_MESSAGE);
        }
        if (user.geteMail() != null && !userService.uniqueEmail(user)) {
            return error(AjaxResult.USER_EMAIL_EXITS_CODE, AjaxResult.USER_EMAIL_EXITS_MESSAGE);
        }
        return toAjax(userService.save(user));
    }
}
