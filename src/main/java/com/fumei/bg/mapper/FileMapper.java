package com.fumei.bg.mapper;

import com.fumei.bg.domain.File;
import com.fumei.bg.domain.FileExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author zkh
 */
public interface FileMapper {
    /**
     * 查询目标条目数
     * @param example 条件
     * @return 目标条目数
     */
    long countByExample(FileExample example);

    /**
     * 根据条件删除记录
     * @param example 条件
     * @return 删除条目数
     */
    int deleteByExample(FileExample example);

    /**
     * 根据主键删除记录
     * @param fileId id
     * @return 删除条目数
     */
    int deleteByPrimaryKey(Long fileId);

    /**
     * 新增记录
     * @param record 数据对象
     * @return 新增条目数
     */
    int insert(File record);

    /**
     * 新增记录
     * @param record 数据对象
     * @return 新增条目数
     */
    int insertSelective(File record);

    /**
     * 根据条件查询目标记录
     * @param example 条件
     * @return 目标记录集合
     */
    List<File> selectByExample(FileExample example);

    /**
     * 根据主键查询目标
     * @param fileId 主键id
     * @return 目标数据对象
     */
    File selectByPrimaryKey(Long fileId);

    /**
     * 根据条件修改对象
     * @param record 数据对象
     * @param example 条件
     * @return 修改记录条目数
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     * 根据条件修改对象
     * @param record 数据对象
     * @param example 条件
     * @return 修改记录条目数
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    /**
     * 根据主键修改对象
     * @param record 数据对象
     * @return 修改记录条目数
     */
    int updateByPrimaryKeySelective(File record);

    /**
     * 根据主键修改对象
     * @param record 数据对象
     * @return 修改记录条目数
     */
    int updateByPrimaryKey(File record);
}