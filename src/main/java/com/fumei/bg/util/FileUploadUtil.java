package com.fumei.bg.util;

import com.fumei.bg.config.Global;
import com.fumei.bg.domain.system.SysFile;
import com.fumei.bg.exception.FileException;
import com.fumei.bg.service.system.ISysFileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * @author zkh
 */
public class FileUploadUtil {
    private final static String BASE_PATH = Global.getConfig("profile.path");
    public static SysFile fileUpload(MultipartFile uploadFile) throws IOException, FileException {
        if(uploadFile == null || uploadFile.isEmpty()){
            return null;
        }
        String md5 = MD5Util.MD5Encoding(uploadFile.getBytes());
        SysFile sysFile = new SysFile();
        sysFile.setMd5(md5);
        SysFile sysFile1 = SpringUtils.getBean(ISysFileService.class).checkFileNotExist(sysFile);
        if(StringUtils.isNotNull(sysFile1)){
            throw new FileException("文件已存在，取消上传，返回已存在的对象",sysFile1);
        }
        sysFile.setOriginalName(uploadFile.getOriginalFilename());
        sysFile.setContentType(uploadFile.getContentType());
        sysFile.setFileSize(FileUtil.getFileSize(uploadFile));
        sysFile.setFileType(FileUtil.getFileType(Objects.requireNonNull(uploadFile)));
        java.io.File dest = FileUtil.createNewFile(BASE_PATH, uploadFile.getOriginalFilename(), sysFile);
        uploadFile.transferTo(dest);
        sysFile.setName(dest.getName());
        return sysFile;
    }
}
