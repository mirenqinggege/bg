package com.fumei.bg.mapper.system;

import com.fumei.bg.domain.system.SysDictType;

import java.util.List;

/**
 * @author zkh
 */
public interface SysDictTypeMapper {
    /**
     * 根据条件查询字典类型列表
     *
     * @param dictType 条件
     * @return 字典类型列表
     */
    List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * 保存字典类型
     *
     * @param dictType 字典类型
     * @return 执行结果 1成功 0失败
     */
    int insert(SysDictType dictType);

    /**
     * 修改字典类型
     * @param dictType 字典类型
     * @return 执行结果 1成功 0失败
     */
    int update(SysDictType dictType);

    /**
     * 删除字典类型
     * @param dictId 字典id
     * @return 执行结果 1成功 0失败
     */
    int delete(Long dictId);

    /**
     * 根据id获取字典类型
     *
     * @param dictId 字典id
     * @return 字典类型
     */
    SysDictType selectDictByPrimaryKey(Long dictId);
}
