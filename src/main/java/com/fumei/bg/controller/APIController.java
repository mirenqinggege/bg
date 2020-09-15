package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.SysFile;
import com.fumei.bg.exception.FileException;
import com.fumei.bg.service.IFileService;
import com.fumei.bg.util.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 * @author zkh
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@RestController
@RequestMapping("/api")
public class APIController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(APIController.class);

    private final IFileService fileService;

    public APIController(IFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file){
        SysFile sysFile1;
        try {
            sysFile1 = FileUploadUtil.fileUpload(file);
        } catch (IOException | FileException e) {
            log.error("文件 {} 上传错误 详细信息：{}", file.getOriginalFilename(), e.getMessage());
            return error(AjaxResult.SERVER_ERROR_CODE, "文件上传错误");
        }
        int save = 0;
        try {
            save = fileService.save(sysFile1);
        } catch (FileException e) {
            log.error("数据库中已存在 {} 该文件", sysFile1.getOriginalName());
        }
        return toAjax(save);
    }
}
