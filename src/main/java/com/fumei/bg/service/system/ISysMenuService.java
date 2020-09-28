package com.fumei.bg.service.system;

import com.fumei.bg.domain.system.SysMenu;
import com.fumei.bg.domain.system.vo.RouterVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkh
 */
public interface ISysMenuService {
    /**
     * 获取树形菜单
     * @return 菜单集合
     */
    List<SysMenu> getTreeMenus(SysMenu menu);

    /**
     * 构建前端路由信息
     * @param menus 菜单集合
     * @return 路由集合
     */
    ArrayList<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * 查询菜单
     * @param menu 菜单对象
     * @return 菜单对象集合
     */
    List<SysMenu> selectMenu(SysMenu menu);

    /**
     * 根据主键id查询菜单
     * @param menuId 菜单id
     * @return 菜单对象
     */
    SysMenu selectMenuByPrimary(Long menuId);

    /**
     * 保存菜单信息
     * @param menu 菜单
     * @return 是否成功 1成功 0失败
     */
    int save(SysMenu menu);

    /**
     * 修改菜单信息
     * @param menu 菜单信息
     * @return 是否成功 1成功 0失败
     */
    int edit(SysMenu menu);

    /**
     * 获取根菜单
     * @return 菜单集合
     */
    List<SysMenu> getRootMenus();

    /**
     * 根据id删除
     * @param menuId id
     * @return 执行结果 1成功 0失败
     */
    int deleteById(Long menuId);
}
