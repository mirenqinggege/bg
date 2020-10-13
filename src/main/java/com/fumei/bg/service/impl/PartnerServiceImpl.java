package com.fumei.bg.service.impl;

import com.fumei.bg.domain.web.Partner;
import com.fumei.bg.mapper.PartnerMapper;
import com.fumei.bg.service.IPartnerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class PartnerServiceImpl implements IPartnerService {
    private final PartnerMapper mapper;

    public PartnerServiceImpl(PartnerMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 查询合作人列表
     *
     * @param partner 条件
     * @return 合作人列表
     */
    @Override
    public List<Partner> getPartnerList(Partner partner) {
        return mapper.selectPartnerList(partner);
    }

    /**
     * 保存合作人信息
     * @param partner 合作人信息
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int save(Partner partner) {
        return mapper.insert(partner);
    }

    /**
     * 修改合作人信息
     * @param partner 合作人信息
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int edit(Partner partner) {
        return mapper.updateByPrimaryKey(partner);
    }

    /**
     * 删除合作人信息
     * @param pId 合作人信息id
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int remove(Long pId) {
        return mapper.deleteByPrimaryKey(pId);
    }
}
