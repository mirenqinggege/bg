package com.fumei.bg.service.system.impl;

import com.fumei.bg.common.Constant;
import com.fumei.bg.domain.system.SysIcon;
import com.fumei.bg.mapper.system.SysIconMapper;
import com.fumei.bg.service.system.ISysIconService;
import com.fumei.bg.util.RedisCache;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class SysIconServiceImpl implements ISysIconService {
    private final SysIconMapper mapper;
    private final RedisCache redisCache;

    public SysIconServiceImpl(SysIconMapper mapper, RedisCache redisCache) {
        this.mapper = mapper;
        this.redisCache = redisCache;
    }



    /**
     * 获取所有图标
     *
     * @return 图标集合
     */
    @Override
    public List<SysIcon> getAllIcons() {
        List<SysIcon> sysIcons = redisCache.getCacheList(Constant.ICON_PREFIX);
        if(sysIcons.isEmpty()){
            sysIcons = mapper.selectIcons();
            redisCache.setCacheList(Constant.ICON_PREFIX, sysIcons);
        }
        return sysIcons;
    }
}
