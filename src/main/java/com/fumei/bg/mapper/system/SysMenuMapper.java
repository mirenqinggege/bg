package com.fumei.bg.mapper.system;

import com.fumei.bg.domain.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkh
 */
public interface SysMenuMapper {

    /**
     * 查询顶级菜单
     *
     * @return 菜单集合
     */
    List<SysMenu> selectMenuByParentIdIsNull();

    /**
     * 查询子菜单
     * @param parentId 父菜单id
     * @return 菜单集合
     */
    List<SysMenu> selectMenuByParentId(Long parentId);

    /**
     * 获取菜单
     * @param menu 菜单对象
     * @return 菜单对象集合
     */
    ArrayList<SysMenu> selectMenu(SysMenu menu);

    /**
     * 根据id查询菜单
     * @param menuId id
     * @return 菜单对象
     */
    SysMenu selectMenuByPrimary(Long menuId);

    /**
     * 修改菜单信息
     * @param menu 菜单信息
     * @return 是否成功 1成功 0失败
     */
    int updateByPrimaryKey(SysMenu menu);

    /**
     * 保存菜单信息
     * @param menu 菜单信息
     * @return 是否成功 1成功 0失败
     */
    int insert(SysMenu menu);

    /**
     * 查询所有状态正常的菜单
     * @return 菜单集合
     */
    List<SysMenu> selectAllMenus();

    /**
     * 根据id删除
     *
     * @param menuId id
     * @return 执行结果 1成功 0失败
     */
    int deleteById(Long menuId);
}
