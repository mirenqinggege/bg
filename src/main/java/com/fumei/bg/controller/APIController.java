package com.fumei.bg.controller;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.system.SysFile;
import com.fumei.bg.exception.FileException;
import com.fumei.bg.service.system.ISysFileService;
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

    private final ISysFileService fileService;

    public APIController(ISysFileService fileService) {
        this.fileService = fileService;
    }
}
