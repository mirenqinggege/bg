package com.fumei.bg.service.system.impl;

import com.fumei.bg.domain.system.SysDictData;
import com.fumei.bg.mapper.system.SysDictDataMapper;
import com.fumei.bg.service.system.ISysDictDataService;
import com.fumei.bg.util.RedisCache;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService {
    private final SysDictDataMapper mapper;
    private final RedisCache redisCache;

    public SysDictDataServiceImpl(SysDictDataMapper mapper, RedisCache redisCache) {
        this.mapper = mapper;
        this.redisCache = redisCache;
    }

    /**
     * 根据条件获取字典数据列表
     *
     * @param dictData 条件
     * @return 字典数据列表
     */
    @Override
    public List<SysDictData> getDictDataList(SysDictData dictData) {
        List<SysDictData> sysDictData = redisCache.getCacheList(dictData.getDictType());
        if (sysDictData.isEmpty()) {
            sysDictData = mapper.selectDictDataList(dictData);
            redisCache.setCacheList(dictData.getDictType(), sysDictData);
        }
        return sysDictData;
    }

    /**
     * 修改字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int edit(SysDictData dictData) {
        int update = mapper.update(dictData);
        if (update != 0) {
            redisCache.deleteObject(dictData.getDictType());
        }
        return update;
    }

    /**
     * 保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int save(SysDictData dictData) {
        int insert = mapper.insert(dictData);
        if (insert != 0) {
            redisCache.deleteObject(dictData.getDictType());
        }
        return insert;
    }

    /**
     * 删除字典数据
     *
     * @param dataId 字典数据id
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int remove(Long dataId) {
        return mapper.delete(dataId);
    }
}
