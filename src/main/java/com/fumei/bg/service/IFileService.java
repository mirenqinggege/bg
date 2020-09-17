package com.fumei.bg.service;

import com.fumei.bg.domain.system.SysFile;
import com.fumei.bg.exception.FileException;

/**
 * @author zkh
 */
public interface IFileService {

    /**
     * 保存文件信息
     * @param sysFile 文件
     * @throws FileException 文件存在异常
     * @return 成功 1 失败 0
     */
    int save(SysFile sysFile) throws FileException;
}
