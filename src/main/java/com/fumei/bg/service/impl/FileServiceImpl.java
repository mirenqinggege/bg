package com.fumei.bg.service.impl;

import com.fumei.bg.domain.File;
import com.fumei.bg.domain.FileExample;
import com.fumei.bg.exception.FileException;
import com.fumei.bg.mapper.FileMapper;
import com.fumei.bg.service.IFileService;
import com.fumei.bg.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zkh
 */
@Service
public class FileServiceImpl implements IFileService {

    private final FileMapper mapper;

    public FileServiceImpl(FileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int save(File file) throws FileException {
        FileExample fe = new FileExample();
        fe.createCriteria().andMd5EqualTo(file.getMd5());
        if (mapper.countByExample(fe) != 0L){
            throw new FileException("文件已存在");
        }
        file.setCreateTime(DateUtils.currentTime());
        file.setIsDelete(0);
        return mapper.insert(file);
    }
}
