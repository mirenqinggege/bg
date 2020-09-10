package com.fumei.bg.mapper;

import com.fumei.bg.domain.BannerBase;

import java.util.List;

/**
 * @author zkh
 */
public interface BannerBaseMapper {

    /**
     * 根据id查询
     * @param bannerId id
     * @return 结果
     */
    BannerBase selectById(Long bannerId);

    /**
     * 查询正在被使用的
     * @return banner集合
     */
    List<BannerBase> selectByUse();

    /**
     * 插入数据
     * @param bannerBase 数据
     * @return 插入行数
     */
    int insert(BannerBase bannerBase);

    /**
     * 根据id修改
     * @param bannerBase 被修改的数据
     * @return 修改结果（成功1 失败0）
     */
    int updateById(BannerBase bannerBase);
}
