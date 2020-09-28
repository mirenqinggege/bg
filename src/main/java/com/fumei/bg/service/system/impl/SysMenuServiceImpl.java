package com.fumei.bg.service.system.impl;

import com.fumei.bg.domain.system.SysMenu;
import com.fumei.bg.domain.system.vo.RouterVo;
import com.fumei.bg.mapper.system.SysMenuMapper;
import com.fumei.bg.service.system.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author zkh
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    public static final String HELLO_WORLD = "HelloWorld";
    public static final String MENU_TYPE = "M";
    public static final String BUTTON_TYPE = "B";
    public static final String OUT_HREF = "_blank";
    public static final String IN_HREF = "_self";


    private final SysMenuMapper menuMapper;

    public SysMenuServiceImpl(SysMenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    /**
     * 获取树形菜单 （不包括禁用菜单）
     *
     * @return 菜单集合
     */
    @Override
    public List<SysMenu> getTreeMenus(SysMenu menu) {
        List<SysMenu> menus = menuMapper.selectMenu(menu);
        return buildTree(menus);
    }

    /**
     * 构建树菜单
     *
     * @param menus 菜单集合
     */
    private List<SysMenu> buildTree(List<SysMenu> menus) {
        List<SysMenu> result = new ArrayList<>();
        for (SysMenu menu : menus) {
            if (menu.getParentId() == null) {
                recursive(menus, menu);
                result.add(menu);
            }
        }
        if (result.isEmpty()) {
            return menus;
        }
        return result;
    }

    private void recursive(List<SysMenu> menus, SysMenu next) {
        List<SysMenu> list = getChildList(menus, next);
        next.setChild(list);
        for (SysMenu menu : list) {
            if (menu.getHasChild()) {
                for (SysMenu sysMenu : list) {
                    recursive(list, sysMenu);
                }
            }
        }
    }

    private List<SysMenu> getChildList(List<SysMenu> menus, SysMenu next) {
        List<SysMenu> list = new ArrayList<>();
        for (SysMenu menu : menus) {
            if (menu.getParentId() != null && menu.getParentId().longValue() == next.getMenuId().longValue()) {
                list.add(menu);
            }
        }
        return list;
    }

    /**
     * 构建前端路由信息
     *
     * @param menus
     * @return
     */
    @Override
    public ArrayList<RouterVo> buildMenus(List<SysMenu> menus) {
        ArrayList<RouterVo> list = new ArrayList<>();
        Consumer<SysMenu> action = menu -> {
            if (SysMenuServiceImpl.OUT_HREF.equals(menu.getTarget())) {
                return;
            }
            RouterVo router = new RouterVo();
            router.setPath(getRouterPath(menu));
            router.setComponent(getComponent(menu));
            router.setName(getRouterName(menu));
            List<SysMenu> child = menu.getChild();
            if (!child.isEmpty()) {
                router.setChildren(buildMenus(child));
            }
            list.add(router);
        };
        menus.forEach(action);
        return list;
    }

    private String getRouterPath(SysMenu menu) {
        return menu.getPath();
    }

    private String getComponent(SysMenu menu) {
        String component = menu.getComponent();
        if (MENU_TYPE.equals(menu.getType())) {
            component = HELLO_WORLD;
        }
        return component;
    }

    private String getRouterName(SysMenu menu) {
        return menu.getName();
    }

    /**
     * 查询菜单
     *
     * @param menu 菜单对象
     * @return 菜单对象集合
     */
    @Override
    public List<SysMenu> selectMenu(SysMenu menu) {
        return menuMapper.selectMenu(menu);
    }

    /**
     * 根据主键id查询菜单
     *
     * @param menuId 菜单id
     * @return 菜单对象
     */
    @Override
    public SysMenu selectMenuByPrimary(Long menuId) {
        return menuMapper.selectMenuByPrimary(menuId);
    }

    /**
     * 保存菜单信息
     *
     * @param menu 菜单
     * @return 是否成功 1成功 0失败
     */
    @Override
    public int save(SysMenu menu) {
        return menuMapper.insert(menu);
    }

    /**
     * 修改菜单信息
     *
     * @param menu 菜单信息
     * @return 是否成功 1成功 0失败
     */
    @Override
    public int edit(SysMenu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }

    /**
     * 获取根菜单
     *
     * @return 菜单集合
     */
    @Override
    public List<SysMenu> getRootMenus() {
        return menuMapper.selectMenuByParentIdIsNull();
    }

    /**
     * 根据id删除
     *
     * @param menuId id
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int deleteById(Long menuId) {
        return menuMapper.deleteById(menuId);
    }
}
