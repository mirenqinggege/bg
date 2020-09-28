package com.fumei.bg.service.system;

import com.fumei.bg.domain.system.SysFile;

import java.io.IOException;

/**
 * @author zkh
 */
public interface ISysFileService {

    /**
     * 保存文件信息
     * @param sysFile 文件
     * @return 成功 1 失败 0
     */
    int save(SysFile sysFile);

    /**
     * 检查文件是否存在
     * @param file 文件
     * @throws IOException 文件被移动导致无法读取
     * @return 是否存在 如果不存在返回null
     */
    SysFile checkFileNotExist(SysFile file) throws IOException;

    /**
     * 根据id查询文件信息
     * @param fileId 文件id
     * @return 文件信息
     */
    SysFile getFileInfoById(Long fileId);
}
