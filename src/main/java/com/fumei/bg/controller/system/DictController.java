package com.fumei.bg.controller.system;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.system.SysDictData;
import com.fumei.bg.domain.system.SysDictType;
import com.fumei.bg.service.system.ISysDictDataService;
import com.fumei.bg.service.system.ISysDictTypeService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    private final ISysDictDataService dataService;
    private final ISysDictTypeService typeService;

    public DictController(ISysDictDataService dataService, ISysDictTypeService typeService) {
        this.dataService = dataService;
        this.typeService = typeService;
    }

    @GetMapping("/getDictTypeList")
    public AjaxResult getDictTypeList(SysDictType dictType){
        return success("获取字典类型列表成功", typeService.getDictTypeList(dictType));
    }

    @GetMapping("/getDictDataList/{dictType}")
    public AjaxResult getDictDataList(@PathVariable String dictType){
        SysDictData dictData = new SysDictData();
        dictData.setDictType(dictType);
        return success("获取字典数据列表成功", dataService.getDictDataList(dictData));
    }

    @PostMapping("/dictTypeSave")
    public AjaxResult dictTypeSave(@RequestBody SysDictType dictType){
        if (dictType.getDictId() == null) {
            return toAjax(typeService.save(dictType), "保存字典类型成功", "保存字典类型失败");
        } else {
            return toAjax(typeService.edit(dictType), "修改字典类型成功","修改字典类型失败");
        }
    }
    
    @PostMapping("/dictDataSave")
    public AjaxResult dictDataSave(@RequestBody SysDictData dictData){
        if (dictData.getDataId() == null) {
            return toAjax(dataService.save(dictData), "保存字典数据成功","保存字典数据失败");
        } else {
            return toAjax(dataService.edit(dictData), "修改字典数据成功", "修改字典数据失败");
        }
    }

    @DeleteMapping("/dictTypeRemove/{dictId}")
    public AjaxResult dictTypeRemove(@PathVariable Long dictId){
        return toAjax(typeService.remove(dictId),"删除字典类型成功","删除字典类型失败");
    }

    @DeleteMapping("/dictDataRemove/{dataId}")
    public AjaxResult dictDataRemove(@PathVariable Long dataId){
        return toAjax(dataService.remove(dataId), "删除字典数据成功", "删除字典数据失败");
    }
}
