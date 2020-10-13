package com.fumei.bg.mapper.system;

import com.fumei.bg.domain.system.SysDictData;
import com.fumei.bg.domain.system.SysDictType;

import java.util.List;
import java.util.Map;

/**
 * @author zkh
 */
public interface SysDictDataMapper {
    /**
     * 根据条件获取字典数据列表
     *
     * @param dictData 条件
     * @return 字典数据列表
     */
    List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 保存字典数据信息
     * @param dictData 字典数据信息
     * @return 执行结果 1成功 0失败
     */
    int insert(SysDictData dictData);

    /**
     * 修改字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 执行结果 1成功 0失败
     */
    int update(SysDictData dictData);

    /**
     * 删除字典数据
     *
     * @param dataId 字典数据id
     * @return 执行结果 1成功 0失败
     */
    int delete(Long dataId);

    /**
     * 根据字典id获取字典数据
     *
     * @param dictId 字典id
     * @return 字典数据集合
     */
    List<SysDictData> selectDictDataListByDictId(Long dictId);

    /**
     * 根据多个id修改字典类型
     *
     * @param map  字典类型 字典数据id
     * @return 执行结果 >0成功 0失败
     */
    int updateDictTypeByIds(Map<String, Object> map);

}
