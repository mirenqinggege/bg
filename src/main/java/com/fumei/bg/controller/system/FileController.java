package com.fumei.bg.controller.system;

import com.fumei.bg.common.AjaxResult;
import com.fumei.bg.common.BaseController;
import com.fumei.bg.domain.system.SysFile;
import com.fumei.bg.exception.FileException;
import com.fumei.bg.service.system.ISysFileService;
import com.fumei.bg.util.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zkh
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    private final ISysFileService fileService;

    public FileController(ISysFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) {
        SysFile file1;
        int save;
        try {
            file1 = FileUploadUtil.fileUpload(file);
            save = fileService.save(file1);
        } catch (IOException e) {
            log.error("上传文件 {} 时出错", file.getOriginalFilename(), e);
            return error("B0100", "上传文件出错");
        } catch (FileException e) {
            log.error("上传文件 {} 时出错", file.getOriginalFilename(), e);
            return success("文件上传成功", e.getData());
        }
        return toAjax(save, "文件上传成功", "文件上传失败", file1);
    }

    @GetMapping("/getFileInfo/{fileId}")
    public AjaxResult getFileInfoById(@PathVariable Long fileId) {
        return success("获取文件信息成功", fileService.getFileInfoById(fileId));
    }
}
