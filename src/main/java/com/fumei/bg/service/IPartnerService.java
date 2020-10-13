package com.fumei.bg.service;

import com.fumei.bg.domain.web.Partner;

import java.util.List;

/**
 * @author zkh
 */
public interface IPartnerService {
    /**
     * 查询合作人列表
     * @param partner 条件
     * @return 合作人列表
     */
    List<Partner> getPartnerList(Partner partner);

    /**
     * 保存合作人信息
     * @param partner 合作人信息
     * @return 执行结果 1成功 0失败
     */
    int save(Partner partner);

    /**
     * 修改合作人信息
     * @param partner 合作人信息
     * @return 执行结果 1成功 0失败
     */
    int edit(Partner partner);

    /**
     * 删除合作人信息
     * @param pId 合作人信息id
     * @return 执行结果 1成功 0失败
     */
    int remove(Long pId);
}
