package com.fumei.bg.mapper;

import com.fumei.bg.domain.web.Partner;

import java.util.List;

/**
 * @author zkh
 */
public interface PartnerMapper {

    /**
     * 查询合作人列表
     * @param partner 条件
     * @return 合作人列表
     */
    List<Partner> selectPartnerList(Partner partner);

    /**
     * 保存合作人信息
     * @param partner 合作人信息
     * @return 执行结果 1成功 0失败
     */
    int insert(Partner partner);

    /**
     * 修改合作人信息
     * @param partner 合作人信息
     * @return 执行结果 1成功 0失败
     */
    int updateByPrimaryKey(Partner partner);

    /**
     * 删除合作人信息
     * @param pId 合作人信息id
     * @return 执行结果 1成功 0失败
     */
    int deleteByPrimaryKey(Long pId);
}
