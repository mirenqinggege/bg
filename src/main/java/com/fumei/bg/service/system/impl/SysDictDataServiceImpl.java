package com.fumei.bg.service.system.impl;

import com.fumei.bg.domain.system.SysDictData;
import com.fumei.bg.domain.system.SysDictType;
import com.fumei.bg.mapper.system.SysDictDataMapper;
import com.fumei.bg.service.system.ISysDictDataService;
import com.fumei.bg.util.RedisCache;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据字典id获取字典数据
     *
     * @param dictId 字典id
     * @return 字典数据集合
     */
    @Override
    public List<SysDictData> getDictDataListByDictId(Long dictId) {
        return mapper.selectDictDataListByDictId(dictId);
    }

    /**
     * 根据多个id修改字典类型
     *
     * @param dictType 字典类型
     * @param dataIds  字典id
     * @return 执行结果 >0成功 0失败
     */
    @Override
    public int editDictTypeByIds(String dictType, List<Long> dataIds) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("dictType", dictType);
        map.put("dataIds", dataIds);
        return mapper.updateDictTypeByIds(map);
    }
}
