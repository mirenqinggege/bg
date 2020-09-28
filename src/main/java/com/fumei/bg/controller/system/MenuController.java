package com.fumei.bg.controller.system;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.system.SysMenu;
import com.fumei.bg.service.system.ISysMenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public AjaxResult init(SysMenu menu) {
        List<SysMenu> menus = menuService.getTreeMenus(menu);
        return success("获取菜单成功", menus);
    }

    @GetMapping("/getMenuInfo")
    public AjaxResult getMenuInfo(Long menuId) {
        return success("获取菜单信息成功", menuService.selectMenuByPrimary(menuId));
    }

    @GetMapping("/getRootMenus")
    public AjaxResult getRootMenus(){
        return success("获取顶级菜单成功", menuService.getRootMenus());
    }

    @GetMapping("/getMenus")
    public AjaxResult getMenus(SysMenu sysMenu){
        return success("获取菜单成功",menuService.selectMenu(sysMenu));
    }

    @GetMapping("/getRoutes")
    public AjaxResult getRoutes() {
        SysMenu menu = new SysMenu();
        menu.setStatus("0");
        return success("获取路由信息成功", menuService.buildMenus(menuService.getTreeMenus(menu)));
    }

    @PostMapping("/save")
    public AjaxResult save(@RequestBody SysMenu menu) {
        if(menu.getMenuId() == null){
            return toAjax(menuService.save(menu), "保存菜单信息成功", "保存菜单信息失败");
        }else{
            return toAjax(menuService.edit(menu), "修改菜单信息成功", "修改菜单信息失败");
        }
    }

    @DeleteMapping("/deleteById/{menuId}")
    public AjaxResult delete(@PathVariable Long menuId){
        SysMenu menu = menuService.selectMenuByPrimary(menuId);
        if (menu.getHasChild()) {
            return error(AjaxResult.SERVER_ERROR_CODE, "存在子菜单无法删除");
        }
        return toAjax(menuService.deleteById(menuId), "删除菜单成功", "删除菜单失败");
    }
}
