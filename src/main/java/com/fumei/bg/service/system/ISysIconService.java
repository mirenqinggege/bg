package com.fumei.bg.service.system;

import com.fumei.bg.domain.system.SysIcon;

import java.util.List;

/**
 * @author zkh
 */
public interface ISysIconService {

    /**
     * 获取所有图标
     * @return 图标集合
     */
    List<SysIcon> getAllIcons();
}
