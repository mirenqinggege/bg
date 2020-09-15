package com.fumei.bg.util;

import com.fumei.bg.config.Global;
import com.fumei.bg.domain.SysFile;
import com.fumei.bg.exception.FileException;
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
        SysFile sysFile = new SysFile();
        java.io.File dest = FileUtil.createNewFile(BASE_PATH, uploadFile.getOriginalFilename(), sysFile);
        sysFile.setOriginalName(uploadFile.getOriginalFilename());
        sysFile.setContentType(uploadFile.getContentType());
        sysFile.setFileSize(FileUtil.getFileSize(uploadFile));
        uploadFile.transferTo(dest);
        sysFile.setMd5(FileUtil.fileEncoding(dest));
        sysFile.setName(FileUtil.fileNameEncoding(Objects.requireNonNull(uploadFile.getOriginalFilename())));
        return sysFile;
    }
}
