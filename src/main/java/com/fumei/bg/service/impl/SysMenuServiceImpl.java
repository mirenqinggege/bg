package com.fumei.bg.service.impl;

import com.fumei.bg.domain.system.SysMenu;
import com.fumei.bg.domain.system.vo.RouterVo;
import com.fumei.bg.mapper.SysMenuMapper;
import com.fumei.bg.service.ISysMenuService;
import com.fumei.bg.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
     * 获取树形菜单
     *
     * @return 菜单集合
     */
    @Override
    public ArrayList<SysMenu> getTreeMenus() {
        ArrayList<SysMenu> menus = menuMapper.selectMenuByParentIdIsNull();
        getChilds(menus);
        return menus;
    }

    /**
     * 递归调用查询子菜单
     *
     * @param menus 菜单集合
     */
    private void getChilds(List<SysMenu> menus) {
        if (menus.isEmpty()) {
            return;
        }
        menus.forEach((menu) -> {
            ArrayList<SysMenu> child = menuMapper.selectMenuByParentId(menu.getMenuId());
            getChilds(child);
            menu.setChild(child);
        });
    }

    /**
     * 递归遍历菜单集合执行操作
     *
     * @param menus  菜单集合
     * @param action 执行内容
     */
    private void recursion(List<SysMenu> menus, Consumer<SysMenu> action) {
        if (menus.isEmpty()) {
            return;
        }
        menus.forEach(value -> {
            action.accept(value);
            recursion(value.getChild(), action);
        });
    }

    /**
     * 构建前端路由信息
     *
     * @param menus
     * @return
     */
    @Override
    public ArrayList<RouterVo> buildMenus(ArrayList<SysMenu> menus) {
        ArrayList<RouterVo> list = new ArrayList<>();
        menus.forEach(menu -> {
            RouterVo router = new RouterVo();
            router.setPath(getRouterPath(menu));
            router.setComponent(getComponent(menu));
            router.setName(getRouterName(menu));
            ArrayList<SysMenu> child = menu.getChild();
            if (!child.isEmpty()) {
                router.setChildren(buildMenus(child));
            }
            list.add(router);
        });
        return list;
    }

    private String getRouterPath(SysMenu menu) {
        String path = menu.getPath();
        if (MENU_TYPE.equals(menu.getType()) && IN_HREF.equals(menu.getTarget())) {
            path = "/";
        }
        return path;
    }

    private String getComponent(SysMenu menu) {
        String component = HELLO_WORLD;
        if ((OUT_HREF.equals(menu.getTarget()) || BUTTON_TYPE.equals(menu.getType())) && StringUtils.isNotEmpty(menu.getComponent())) {
            component = menu.getComponent();
        }
        return component;
    }

    private String getRouterName(SysMenu menu) {
        String name = menu.getName();
        if (MENU_TYPE.equals(menu.getType()) && IN_HREF.equals(menu.getTarget())) {
            name = StringUtils.EMPTY;
        }
        return name;
    }

    /**
     * 查询菜单
     *
     * @param menu 菜单对象
     * @return 菜单对象集合
     */
    @Override
    public ArrayList<SysMenu> selectMenu(SysMenu menu) {
        return menuMapper.selectMenu(menu);
    }
}
