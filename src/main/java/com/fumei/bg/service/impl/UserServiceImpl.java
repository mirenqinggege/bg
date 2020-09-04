package com.fumei.bg.service.impl;

import com.fumei.bg.domain.User;
import com.fumei.bg.domain.UserExample;
import com.fumei.bg.mapper.UserMapper;
import com.fumei.bg.service.IUserService;
import com.fumei.bg.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class UserServiceImpl implements IUserService {
    public final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean uniqueNumber(User user) {
        UserExample ue = new UserExample();
        ue.createCriteria().andNumberEqualTo(user.getNumber());
        return mapper.countByExample(ue) == 0L;
    }

    @Override
    public boolean uniqueEmail(User user) {
        UserExample ue = new UserExample();
        ue.createCriteria().andEMailEqualTo(user.geteMail());
        return mapper.countByExample(ue) == 0L;
    }

    @Override
    public int save(User user) {
        user.setCreateTime(DateUtils.currentTime());
        user.setStatus(0);
        return mapper.insert(user);
    }

    /**
     * 根据用户名查询用户
     *
     * @param loginName 用户名
     * @return 用户对象
     */
    @Override
    public User getUserByLoginName(String loginName) {
        UserExample ue = new UserExample();
        ue.createCriteria().andLoginNameEqualTo(loginName);
        List<User> users = mapper.selectByExample(ue);
        return users.isEmpty() ? null : users.get(0);
    }

    /**
     * 根据邮箱查询用户
     *
     * @param eMail 邮箱
     * @return 用户对象
     */
    @Override
    public User getUserByEmail(String eMail) {
        UserExample ue = new UserExample();
        ue.createCriteria().andEMailEqualTo(eMail);
        List<User> users = mapper.selectByExample(ue);
        return users.isEmpty() ? null : users.get(0);
    }

    /**
     * 根据手机号查询用户
     *
     * @param number 手机号
     * @return 用户对象
     */
    @Override
    public User getUserByNumber(String number) {
        UserExample ue = new UserExample();
        ue.createCriteria().andNumberEqualTo(number);
        List<User> users = mapper.selectByExample(ue);
        return users.isEmpty() ? null : users.get(0);
    }
}
