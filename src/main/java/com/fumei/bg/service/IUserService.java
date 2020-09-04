package com.fumei.bg.service;

import com.fumei.bg.domain.User;

/**
 * @author zkh
 */
public interface IUserService {
    /**
     *  检查手机号是否唯一
     * @param user 用户对象
     * @return 手机号是否唯一
     */
    boolean uniqueNumber(User user);

    /**
     * 检查邮箱是否唯一
     * @param user 用户对象
     * @return 邮箱是否唯一
     */
    boolean uniqueEmail(User user);

    /**
     * 保存用户对象
     * @param user 用户对象
     * @return 是否新增成功（0 失败 1 失败）
     */
    int save(User user);

    /**
     * 根据用户名查询用户
     * @param loginName 用户名
     * @return 用户对象
     */
    User getUserByLoginName(String loginName);

    /**
     * 根据邮箱查询用户
     * @param eMail 邮箱
     * @return 用户对象
     */
    User getUserByEmail(String eMail);

    /**
     * 根据手机号查询用户
     * @param number 手机号
     * @return 用户对象
     */
    User getUserByNumber(String number);
}
