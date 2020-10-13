package com.fumei.bg.controller;

import cn.hutool.core.util.ObjectUtil;
import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.common.Constant;
import com.fumei.bg.domain.web.Partner;
import com.fumei.bg.service.IPartnerService;
import com.fumei.bg.service.system.ISysFileService;
import com.fumei.bg.util.Convert;
import org.springframework.boot.autoconfigure.security.oauth2.resource.IssuerUriCondition;
import org.springframework.web.bind.annotation.*;

/**
 * 合作人
 *
 * @author zkh
 */
@RestController
@RequestMapping("/partner")
public class PartnerController extends BaseController {

    private final IPartnerService partnerService;

    public PartnerController(IPartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/getPartnerList")
    public AjaxResult getPartnerList(Partner partner) {
        startPage();
        return success("获取合作人信息列表成功", toPageList(partnerService.getPartnerList(partner)));
    }

    @GetMapping("/getPartnerListByUse")
    public AjaxResult getPartnerListByUse(){
        Partner partner = new Partner();
        partner.setUse(Constant.ELEMENT_USE);
        return success("获取合作人信息列表成功", partnerService.getPartnerList(partner));
    }

    @PostMapping("/save")
    public AjaxResult save(@RequestBody Partner partner) {
        if (ObjectUtil.isEmpty(partner.getPId())) {
            return toAjax(partnerService.save(partner), "保存合作人信息成功", "保存合作人信息失败");
        } else {
            return toAjax(partnerService.edit(partner), "修改合作人信息成功", "修改合作人信息失败");
        }
    }

    @DeleteMapping("/remove/{pId}")
    public AjaxResult remove(@PathVariable Long pId){
        return toAjax(partnerService.remove(pId), "删除合作人信息成功", "删除合作人信息失败");
    }
}
