package com.fumei.bg.service.impl;

import com.fumei.bg.domain.system.SysFile;
import com.fumei.bg.domain.system.SysFileExample;
import com.fumei.bg.exception.FileException;
import com.fumei.bg.mapper.SysFileMapper;
import com.fumei.bg.service.IFileService;
import com.fumei.bg.util.DateUtils;
import org.springframework.stereotype.Service;

/**
 * @author zkh
 */
@Service
public class FileServiceImpl implements IFileService {

    private final SysFileMapper mapper;

    public FileServiceImpl(SysFileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int save(SysFile sysFile) throws FileException {
        SysFileExample fe = new SysFileExample();
        fe.createCriteria().andMd5EqualTo(sysFile.getMd5());
        if (mapper.countByExample(fe) != 0L){
            throw new FileException("文件已存在");
        }
        sysFile.setCreateTime(DateUtils.currentTime());
        sysFile.setIsDelete(0);
        return mapper.insert(sysFile);
    }
}
