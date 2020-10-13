package com.fumei.bg.common;

import com.fumei.bg.util.ServletUtil;
import com.fumei.bg.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 控制器基础类
 *
 * @author zkh
 */
public class BaseController {

    protected void startPage(){
        String parameter = ServletUtil.getRequest().getParameter(Constant.PAGE_NUM);
        String parameter1 = ServletUtil.getRequest().getParameter(Constant.PAGE_SIZE);
        int pageNum = Integer.parseInt(StringUtils.isNull(parameter) ? "1" : parameter);
        int pageSize = Integer.parseInt(StringUtils.isNull(parameter1) ? "6" : parameter1);
        PageHelper.startPage(pageNum, pageSize);
    }

    protected <T> PageInfo<T> toPageList(List<T> list){
        return new PageInfo<>(list);
    }



    /**
     * 返回成功信息
     *
     * @return ajax body
     */
    protected static AjaxResult success() {
        return success(AjaxResult.REQUEST_SUCCESS_MESSAGE, null);
    }

    /**
     * 返回成功信息
     *
     * @param message 成功信息
     * @return ajax body
     */
    protected static AjaxResult success(String message) {
        return success(message, null);
    }

    /**
     * 返回成功信息
     *
     * @param message 成功信息
     * @param data    返回数据
     * @return ajax body
     */
    protected static AjaxResult success(String message, Object data) {
        return new AjaxResult(AjaxResult.REQUEST_SUCCESS_CODE, message, data);
    }

    /**
     * 返回错误信息
     *
     * @param code    错误代码
     * @param message 错误信息
     * @return ajax body
     */
    protected static AjaxResult error(String code, String message) {
        return new AjaxResult(code, message);
    }

    /**
     * 返回错误信息
     *
     * @param rows         数据库修改行数
     * @param errorCode    错误代码
     * @param errorMessage 错误信息
     * @param success      成功信息
     * @return ajax body
     */
    protected static AjaxResult toAjax(int rows, String success, String errorCode, String errorMessage, Object data) {
        return rows > 0 ? success(success, data) : error(errorCode, errorMessage);
    }

    /**
     * 返回错误信息
     *
     * @param rows 数据库修改行数
     * @return ajax body
     */
    protected static AjaxResult toAjax(int rows) {
        return toAjax(rows, AjaxResult.REQUEST_SUCCESS_MESSAGE, AjaxResult.SERVER_ERROR_CODE, AjaxResult.SERVER_ERROR_MESSAGE, null);
    }

    protected static AjaxResult toAjax(int rows, String successMessage, String errorMessage) {
        return toAjax(rows, successMessage, errorMessage, null);
    }

    protected static AjaxResult toAjax(int rows, String successMessage, String errorMessage, Object data) {
        return toAjax(rows, successMessage, AjaxResult.SERVER_ERROR_CODE, errorMessage, data);
    }
}
