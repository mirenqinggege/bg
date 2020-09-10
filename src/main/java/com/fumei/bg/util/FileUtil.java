package com.fumei.bg.util;

import com.fumei.bg.exception.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @author zkh
 */
public class FileUtil {
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);
    public static String getFileSize(MultipartFile file) {
        int kb = 1024, mb = kb * 1024, gb = mb * 1024;
        long size = file.getSize();
        double result;
        System.err.println(size);
        String unit;
        if (size > kb && size > mb && size > gb) {
            result = (double) size / gb;
            unit = "GB";
        } else if (size > kb && size > mb) {
            result = (double) size / mb;
            unit = "MB";
        } else if (size > kb) {
            result = (double) size / kb;
            unit = "KB";
        } else {
            result = size;
            unit = "B";
        }
        return new DecimalFormat("#.00").format(result) + " " + unit;
    }

    public static File createNewFile(String basePath, String originalFilename, com.fumei.bg.domain.File file2) throws FileException {
        String dateFilePath = DateUtils.getDateFilePath();
        String path = basePath + "/" + dateFilePath, fileName = FileUtil.fileNameEncoding(originalFilename);
        File file = new File(path), file1 = new File(path + "/" + fileName);
        if (file1.exists()) {
            throw new FileException("文件已存在");
        }
        if (file.exists() && file.isDirectory()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                log.error(e.getMessage(),e);
            }
        } else {
            if (file.mkdirs()) {
                try {
                    file1.createNewFile();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        file2.setPath("/static/" + dateFilePath + "/" + fileName);
        return file1;
    }

    public static String fileNameEncoding(String originalFilename) {
        int index = originalFilename.lastIndexOf(".");
        String fileName = originalFilename.substring(0, index);
        return MD5Util.MD5Encoding(fileName) + originalFilename.substring(index);
    }

    public static String fileEncoding(File file) {
        return MD5Util.MD5Encoding(file);
    }
}
