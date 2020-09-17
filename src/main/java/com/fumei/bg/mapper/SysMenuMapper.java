package com.fumei.bg.mapper;

import com.fumei.bg.domain.system.SysMenu;

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

    /**
     * 获取菜单
     * @param menu 菜单对象
     * @return 菜单对象集合
     */
    ArrayList<SysMenu> selectMenu(SysMenu menu);
}
