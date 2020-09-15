package com.fumei.bg.mapper;

import com.fumei.bg.domain.SysMenu;

import java.util.ArrayList;

/**
 * @author zkh
 */
public interface SysMenuMapper {

    /**
     * 查询顶级菜单
     *
     * @return 菜单集合
     */
    ArrayList<SysMenu> selectMenuByParentIdIsNull();

    /**
     * 查询子菜单
     * @param parentId 父菜单id
     * @return 菜单集合
     */
    ArrayList<SysMenu> selectMenuByParentId(Long parentId);
}
