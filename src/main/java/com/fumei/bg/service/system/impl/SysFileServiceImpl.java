package com.fumei.bg.service.system.impl;

import com.fumei.bg.domain.system.SysFile;
import com.fumei.bg.mapper.system.SysFileMapper;
import com.fumei.bg.service.system.ISysFileService;
import com.fumei.bg.util.DateUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author zkh
 */
@Service
public class SysFileServiceImpl implements ISysFileService {

    private final SysFileMapper mapper;

    public SysFileServiceImpl(SysFileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int save(SysFile sysFile) {
        sysFile.setCreateTime(DateUtils.currentTime());
        sysFile.setIsDelete("0");
        return mapper.insert(sysFile);
    }

    /**
     * 检查文件是否存在
     *
     * @param file  文件
     * @return 是否存在 如果不存在返回null
     */
    @Override
    public SysFile checkFileNotExist(SysFile file) throws IOException {
        List<SysFile> sysFiles = mapper.selectSysFileList(file);
        return sysFiles.isEmpty() ? null : sysFiles.get(0);
    }

    /**
     * 根据id查询文件信息
     *
     * @param fileId 文件id
     * @return 文件信息
     */
    @Override
    public SysFile getFileInfoById(Long fileId) {
        return mapper.selectByPrimaryKey(fileId);
    }
}
