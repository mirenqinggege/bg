package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.web.BannerBase;
import com.fumei.bg.service.IBannerBaseService;
import com.fumei.bg.service.system.ISysFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/banner")
public class BannerBaseController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(BannerBaseController.class);
    private final IBannerBaseService bannerBaseService;

    public BannerBaseController(IBannerBaseService bannerBaseService) {
        this.bannerBaseService = bannerBaseService;
    }

    @GetMapping("/getBanners")
    public AjaxResult getBanners() {
        return success("获取banners成功", bannerBaseService.getUseBanner());
    }

    @GetMapping("/getBannerList")
    public AjaxResult getBannerList(BannerBase banner){
        return success("获取广告列表成功",bannerBaseService.getBannerList(banner));
    }

    @PostMapping("/saveBanner")
    @Transactional
    public AjaxResult saveBanner(@RequestBody BannerBase banner){
        if (banner.getBannerId() == null) {
            return toAjax(bannerBaseService.save(banner), "保存广告信息成功","保存广告信息失败");
        } else {
            return toAjax(bannerBaseService.edit(banner), "修改广告信息成功", "修改广告信息失败");
        }
    }
    
    @DeleteMapping("/delBanner/{bannerId}")
    public AjaxResult delBanner(@PathVariable Long bannerId){
        return toAjax(bannerBaseService.remove(bannerId),"删除广告信息成功","删除广告信息失败");
    }
}
