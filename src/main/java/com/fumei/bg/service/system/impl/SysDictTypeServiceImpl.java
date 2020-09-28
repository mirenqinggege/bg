package com.fumei.bg.service.system.impl;

import com.fumei.bg.domain.system.SysDictType;
import com.fumei.bg.mapper.system.SysDictTypeMapper;
import com.fumei.bg.service.system.ISysDictTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class SysDictTypeServiceImpl implements ISysDictTypeService {
    private final SysDictTypeMapper mapper;

    public SysDictTypeServiceImpl(SysDictTypeMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 根据条件查询字典类型列表
     *
     * @param dictType 条件
     * @return 字典类型列表
     */
    @Override
    public List<SysDictType> getDictTypeList(SysDictType dictType) {
        return mapper.selectDictTypeList(dictType);
    }

    /**
     * 保存字典类型
     *
     * @param dictType 字典类型
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int save(SysDictType dictType) {
        return mapper.insert(dictType);
    }

    /**
     * 修改字典类型
     *
     * @param dictType 字典类型
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int edit(SysDictType dictType) {
        return mapper.update(dictType);
    }

    /**
     * 删除字典类型
     *
     * @param dictId 字典id
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int remove(Long dictId) {
        return mapper.delete(dictId);
    }
}
