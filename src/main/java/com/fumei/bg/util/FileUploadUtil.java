package com.fumei.bg.util;

import com.fumei.bg.config.Global;
import com.fumei.bg.domain.File;
import com.fumei.bg.exception.FileException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * @author zkh
 */
public class FileUploadUtil {
    private final static String BASE_PATH = Global.getConfig("profile.path");
    public static File fileUpload(MultipartFile uploadFile) throws IOException, FileException {
        if(uploadFile == null || uploadFile.isEmpty()){
            return null;
        }
        File file = new File();
        java.io.File dest = FileUtil.createNewFile(BASE_PATH, uploadFile.getOriginalFilename(), file);
        file.setOriginalName(uploadFile.getOriginalFilename());
        file.setContentType(uploadFile.getContentType());
        file.setFileSize(FileUtil.getFileSize(uploadFile));
        uploadFile.transferTo(dest);
        file.setMd5(FileUtil.fileEncoding(dest));
        file.setName(FileUtil.fileNameEncoding(Objects.requireNonNull(uploadFile.getOriginalFilename())));
        return file;
    }
}
