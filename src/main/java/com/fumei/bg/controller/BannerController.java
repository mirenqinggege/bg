package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.web.Banner;
import com.fumei.bg.service.IBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(BannerController.class);
    private final IBannerService bannerService;

    public BannerController(IBannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/getBanners")
    public AjaxResult getBanners() {
        return success("获取banners成功", bannerService.getUseBanner());
    }

    @GetMapping("/getBannerList")
    public AjaxResult getBannerList(Banner banner){
        startPage();
        return success("获取广告列表成功", toPageList(bannerService.getBannerList(banner)));
    }

    @PostMapping("/saveBanner")
    @Transactional
    public AjaxResult saveBanner(@RequestBody Banner banner){
        if (banner.getBannerId() == null) {
            return toAjax(bannerService.save(banner), "保存广告信息成功","保存广告信息失败");
        } else {
            return toAjax(bannerService.edit(banner), "修改广告信息成功", "修改广告信息失败");
        }
    }
    
    @DeleteMapping("/delBanner/{bannerId}")
    public AjaxResult delBanner(@PathVariable Long bannerId){
        return toAjax(bannerService.remove(bannerId),"删除广告信息成功","删除广告信息失败");
    }
}
