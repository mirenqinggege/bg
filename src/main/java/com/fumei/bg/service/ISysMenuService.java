package com.fumei.bg.service;

import com.fumei.bg.domain.system.SysMenu;
import com.fumei.bg.domain.system.vo.RouterVo;

import java.util.ArrayList;

/**
 * @author zkh
 */
public interface ISysMenuService {
    /**
     * 获取树形菜单
     * @return 菜单集合
     */
    ArrayList<SysMenu> getTreeMenus();

    /**
     * 构建前端路由信息
     * @param menus
     * @return
     */
    ArrayList<RouterVo> buildMenus(ArrayList<SysMenu> menus);

    /**
     * 查询菜单
     * @param menu 菜单对象
     * @return 菜单对象集合
     */
    ArrayList<SysMenu> selectMenu(SysMenu menu);
}
