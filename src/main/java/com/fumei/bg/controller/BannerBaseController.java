package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.SysFile;
import com.fumei.bg.domain.web.BannerBase;
import com.fumei.bg.exception.FileException;
import com.fumei.bg.service.IBannerBaseService;
import com.fumei.bg.service.IFileService;
import com.fumei.bg.util.FileUploadUtil;
import com.fumei.bg.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private final IFileService fileService;

    public BannerBaseController(IBannerBaseService bannerBaseService, IFileService fileService) {
        this.bannerBaseService = bannerBaseService;
        this.fileService = fileService;
    }

    @GetMapping("/getBanners")
    public AjaxResult getBanners() {
        return success("获取banners成功", bannerBaseService.getUseBanner());
    }

    @PostMapping("/saveBanner")
    public AjaxResult saveBanner(BannerBase... bannerBase) {
        int i = 0;
        for (BannerBase base : bannerBase) {
            MultipartFile file = base.getFile();
            SysFile f = null;
            if (file != null && !file.isEmpty()) {
                try {
                    f = FileUploadUtil.fileUpload(file);
                    if (fileService.save(f) == 0) {
                        throw new FileException("保存文件信息到数据库失败");
                    }
                    base.setFileId(f.getFileId());
                } catch (IOException | FileException e) {
                    log.error(e.getMessage(), e);
                }
            }
            i += bannerBaseService.save(base);
        }
        return success(StringUtils.format("上传文件{}个，成功{}个，失败{}个",bannerBase.length,i,bannerBase.length - i));
    }
}
