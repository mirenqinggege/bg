package com.fumei.bg.mapper.system;

import com.fumei.bg.domain.system.SysDictData;

import java.util.List;

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
}
