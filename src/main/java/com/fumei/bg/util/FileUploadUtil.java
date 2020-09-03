package com.fumei.bg.util;

import com.fumei.bg.domain.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zkh
 */
public class FileUploadUtil {

    public static File fileUpload(MultipartFile uploadFile){
        if(uploadFile == null || uploadFile.isEmpty()){
            return null;
        }
        File file = new File();
        return file;
    }
}
