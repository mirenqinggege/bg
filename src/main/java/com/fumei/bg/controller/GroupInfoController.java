package com.fumei.bg.controller;

import cn.hutool.core.util.ObjectUtil;
import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.common.Constant;
import com.fumei.bg.domain.web.GroupInfo;
import com.fumei.bg.service.IGroupInfoService;
import com.fumei.bg.service.system.ISysFileService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/group/info")
public class GroupInfoController extends BaseController {
    private final IGroupInfoService infoService;

    public GroupInfoController(IGroupInfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/getGroupInfoList")
    public AjaxResult getGroupInfoList(GroupInfo info) {
        startPage();
        return success("获取集团简介列表成功", toPageList(infoService.getGroupInfoList(info)));
    }

    @GetMapping("/getIndexGroupInfo")
    public AjaxResult getIndexGroupInfo(){
        return success("获取首页集团简介成功", infoService.getIndexGroupInfo());
    }

    @PostMapping("/save")
    @Transactional(rollbackFor = NullPointerException.class)
    public AjaxResult save(@RequestBody GroupInfo info) {
        if (ObjectUtil.isEmpty(info.getInfoId())) {
            return toAjax(infoService.save(info), "保存集团简介成功", "保存集团简介失败");
        } else {
            return toAjax(infoService.edit(info), "修改集团简介成功", "修改集团简介失败");
        }
    }

    @DeleteMapping("/remove/{infoId}")
    public AjaxResult remove(@PathVariable Long infoId){
        return toAjax(infoService.remove(infoId), "删除集团简介成功", "删除集团简介失败");
    }
}
