package com.fumei.bg.mapper.system;

import com.fumei.bg.domain.system.SysFile;

import java.util.List;

/**
 * @author zkh
 */
public interface SysFileMapper {
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
    int insert(SysFile record);

    /**
     * 新增记录
     * @param record 数据对象
     * @return 新增条目数
     */
    int insertSelective(SysFile record);

    /**
     * 根据主键查询目标
     * @param fileId 主键id
     * @return 目标数据对象
     */
    SysFile selectByPrimaryKey(Long fileId);

    /**
     * 根据主键修改对象
     * @param record 数据对象
     * @return 修改记录条目数
     */
    int updateByPrimaryKeySelective(SysFile record);

    /**
     * 根据主键修改对象
     * @param record 数据对象
     * @return 修改记录条目数
     */
    int updateByPrimaryKey(SysFile record);

    /**
     * 查询文件信息列表
     * @param file 条件
     * @return 文件列表
     */
    List<SysFile> selectSysFileList(SysFile file);
}