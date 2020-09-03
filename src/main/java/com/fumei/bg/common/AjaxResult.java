package com.fumei.bg.common;

import java.util.HashMap;
import java.util.Objects;

/**
 * ajax响应体
 * @author zkh
 */
public class AjaxResult {
    public static final String REQUEST_SUCCESS_CODE = "00000",
            REQUEST_SUCCESS_MESSAGE = "操作成功",
            SERVER_ERROR_CODE = "B0001",
            SERVER_ERROR_MESSAGE = "服务端错误",
            CLIENT_ERROR_CODE = "A0001",
            CLIENT_ERROR_MESSAGE = "客户端错误",
            USERNAME_VALIDATE_FAIL_CODE = "A0110",
            USERNAME_VALIDATE_FAIL_MESSAGE = "用户名验证失败",
            USERNAME_EXIST_CODE = "A0111",
            USERNAME_EXIST_MESSAGE = "用户名已存在",
            USERNAME_CONTAIN_SENSITIVE_CHAR_CODE = "A0113",
            USERNAME_CONTAIN_SENSITIVE_CHAR_MESSAGE = "用户名包含敏感字符",
            PASSWORD_VALIDATE_FAIL_CODE = "A0120",
            PASSWORD_VALIDATE_FAIL_MESSAGE = "密码验证失败",
            CAPTCHA_ERROR_CODE = "A0130",
            CAPTCHA_ERROR_MESSAGE = "验证码错误",
            USER_LOGIN_ERROR_CODE = "A0200",
            USER_LOGIN_ERROR_MESSAGE = "账号异常",
            USERNAME_NOT_EXIST_CODE = "A0201",
            USERNAME_NOT_EXIST_MESSAGE = "该用户不存在";


    private String code;
    private String message;
    private Object data;

    public AjaxResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AjaxResult that = (AjaxResult) o;
        return Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage(), getData());
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
