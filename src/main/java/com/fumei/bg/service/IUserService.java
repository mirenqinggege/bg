package com.fumei.bg.service;

import com.fumei.bg.domain.system.SysUser;

/**
 * @author zkh
 */
public interface IUserService {
    /**
     *  检查手机号是否唯一
     * @param sysUser 用户对象
     * @return 手机号是否唯一
     */
    boolean uniqueNumber(SysUser sysUser);

    /**
     * 检查邮箱是否唯一
     * @param sysUser 用户对象
     * @return 邮箱是否唯一
     */
    boolean uniqueEmail(SysUser sysUser);

    /**
     * 保存用户对象
     * @param sysUser 用户对象
     * @return 是否新增成功（0 失败 1 失败）
     */
    int save(SysUser sysUser);

    /**
     * 根据用户名查询用户
     * @param loginName 用户名
     * @return 用户对象
     */
    SysUser getUserByLoginName(String loginName);

    /**
     * 根据邮箱查询用户
     * @param eMail 邮箱
     * @return 用户对象
     */
    SysUser getUserByEmail(String eMail);

    /**
     * 根据手机号查询用户
     * @param number 手机号
     * @return 用户对象
     */
    SysUser getUserByNumber(String number);
}
