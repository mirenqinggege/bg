package com.fumei.bg.service;

import com.fumei.bg.domain.File;
import com.fumei.bg.exception.FileException;

/**
 * @author zkh
 */
public interface IFileService {

    /**
     * 保存文件信息
     * @param file 文件
     * @throws FileException 文件存在异常
     * @return 成功 1 失败 0
     */
    int save(File file) throws FileException;
}
