package com.fumei.bg.controller.system;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.system.SysMenu;
import com.fumei.bg.service.ISysMenuService;
import com.fumei.bg.service.impl.SysMenuServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    private final ISysMenuService menuService;

    public MenuController(ISysMenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/init")
    public AjaxResult init(){
        ArrayList<SysMenu> menus = menuService.getTreeMenus();
        return success("获取菜单成功", menus);
    }

    @GetMapping("/getRoutes")
    public AjaxResult getRoutes(){
        SysMenu menu = new SysMenu();
        menu.setType(SysMenuServiceImpl.BUTTON_TYPE);
        return success("获取路由信息成功",menuService.buildMenus(menuService.selectMenu(menu)));
    }
}
