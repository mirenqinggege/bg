package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.common.Constant;
import com.fumei.bg.domain.web.Trait;
import com.fumei.bg.service.ITraitService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/trait")
public class TraitController extends BaseController {

    private final ITraitService traitService;

    public TraitController(ITraitService traitService) {
        this.traitService = traitService;
    }

    @GetMapping("/getTraitList")
    public AjaxResult getTraitList(Trait trait){
        startPage();
        return success("获取特点列表成功", toPageList(traitService.getTraitList(trait)));
    }
    
    @GetMapping("/getTrait/{traitId}")
    public AjaxResult getTrait(@PathVariable Long traitId){
        return success("获取特点信息成功", traitService.getTrait(traitId));
    }

    @GetMapping("/getTraits")
    public AjaxResult getTraits(){
        Trait trait = new Trait();
        trait.setUse(Constant.ELEMENT_USE);
        return success("获取特点列表信息成功", traitService.getTraitList(trait));
    }
    
    @PostMapping("/save")
    public AjaxResult saveAndEdit(@RequestBody Trait trait){
        if (trait.getTraitId() == null) {
            return toAjax(traitService.insert(trait), "保存特点信息成功", "保存特点信息失败");
        } else {
            return toAjax(traitService.edit(trait), "修改特点信息成功", "修改特点信息失败");
        }
    }

    @DeleteMapping("/remove/{traitId}")
    public AjaxResult remove(@PathVariable Long traitId){
        return toAjax(traitService.remove(traitId), "删除特点信息成功", "删除特点信息失败");
    }
}
