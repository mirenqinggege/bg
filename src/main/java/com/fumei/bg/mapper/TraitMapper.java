package com.fumei.bg.mapper;

import com.fumei.bg.domain.web.Trait;

import java.util.List;

/**
 * @author zkh
 */
public interface TraitMapper {


    /**
     * 查询特点列表
     * @param trait 条件
     * @return 特点列表
     */
    List<Trait> selectTraitList(Trait trait);

    /**
     * 保存特点信息
     * @param trait 特点信息
     * @return 执行结果 1成功  0失败
     */
    int insert(Trait trait);

    /**
     * 修改特点信息
     * @param trait 特点信息
     * @return 执行结果 1成功  0失败
     */
    int updateByPrimaryKey(Trait trait);

    /**
     * 根据id删除特点信息
     * @param traitId 特点id
     * @return 执行结果 1成功  0失败
     */
    int deleteByPrimaryKey(Long traitId);

    /**
     * 根据id查询特点信息
     * @param traitId 特点id
     * @return 特点信息
     */
    Trait selectByPrimaryKey(Long traitId);
}
