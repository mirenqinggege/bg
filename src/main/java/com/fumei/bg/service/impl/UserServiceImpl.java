package com.fumei.bg.service.impl;

import com.fumei.bg.domain.system.SysUser;
import com.fumei.bg.domain.system.SysUserExample;
import com.fumei.bg.mapper.SysUserMapper;
import com.fumei.bg.service.IUserService;
import com.fumei.bg.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class UserServiceImpl implements IUserService {
    public final SysUserMapper mapper;

    public UserServiceImpl(SysUserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean uniqueNumber(SysUser sysUser) {
        SysUserExample ue = new SysUserExample();
        ue.createCriteria().andNumberEqualTo(sysUser.getNumber());
        return mapper.countByExample(ue) == 0L;
    }

    @Override
    public boolean uniqueEmail(SysUser sysUser) {
        SysUserExample ue = new SysUserExample();
        ue.createCriteria().andEMailEqualTo(sysUser.geteMail());
        return mapper.countByExample(ue) == 0L;
    }

    @Override
    public int save(SysUser sysUser) {
        sysUser.setCreateTime(DateUtils.currentTime());
        sysUser.setStatus(0);
        return mapper.insert(sysUser);
    }

    /**
     * 根据用户名查询用户
     *
     * @param loginName 用户名
     * @return 用户对象
     */
    @Override
    public SysUser getUserByLoginName(String loginName) {
        SysUserExample ue = new SysUserExample();
        ue.createCriteria().andLoginNameEqualTo(loginName);
        List<SysUser> sysUsers = mapper.selectByExample(ue);
        return sysUsers.isEmpty() ? null : sysUsers.get(0);
    }

    /**
     * 根据邮箱查询用户
     *
     * @param eMail 邮箱
     * @return 用户对象
     */
    @Override
    public SysUser getUserByEmail(String eMail) {
        SysUserExample ue = new SysUserExample();
        ue.createCriteria().andEMailEqualTo(eMail);
        List<SysUser> sysUsers = mapper.selectByExample(ue);
        return sysUsers.isEmpty() ? null : sysUsers.get(0);
    }

    /**
     * 根据手机号查询用户
     *
     * @param number 手机号
     * @return 用户对象
     */
    @Override
    public SysUser getUserByNumber(String number) {
        SysUserExample ue = new SysUserExample();
        ue.createCriteria().andNumberEqualTo(number);
        List<SysUser> sysUsers = mapper.selectByExample(ue);
        return sysUsers.isEmpty() ? null : sysUsers.get(0);
    }
}
