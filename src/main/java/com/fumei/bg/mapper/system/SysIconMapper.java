package com.fumei.bg.mapper.system;

import com.fumei.bg.domain.system.SysIcon;

import java.util.ArrayList;

/**
 * @author zkh
 */
public interface SysIconMapper {

    /**
     * 获取所有图标
     * @return 图标集合
     */
    ArrayList<SysIcon> selectIcons();
}
