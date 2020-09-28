package com.fumei.bg.controller.system;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.service.system.ISysIconService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/icon")
public class IconController extends BaseController {
    private final ISysIconService iconService;

    public IconController(ISysIconService iconService) {
        this.iconService = iconService;
    }

    @GetMapping()
    public AjaxResult getIcons(){
        return success("获取图标成功", iconService.getAllIcons());
    }
}
