package com.fumei.bg.service.impl;

import cn.hutool.core.util.StrUtil;
import com.fumei.bg.common.Constant;
import com.fumei.bg.domain.web.GroupInfo;
import com.fumei.bg.mapper.GroupInfoMapper;
import com.fumei.bg.service.IGroupInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class GroupInfoServiceImpl implements IGroupInfoService {
    private final GroupInfoMapper mapper;

    public GroupInfoServiceImpl(GroupInfoMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 查询集团简介信息列表
     *
     * @param info 条件
     * @return 集团简介信息列表
     */
    @Override
    public List<GroupInfo> getGroupInfoList(GroupInfo info) {
        return mapper.selectGroupInfoList(info);
    }

    /**
     * 保存集团详情信息
     *
     * @param info 集团简介信息
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int save(GroupInfo info) {
        checkUseCount(info);
        return mapper.insert(info);
    }

    /**
     * 修改集团详情信息
     *
     * @param info 集团简介信息
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int edit(GroupInfo info) {
        checkUseCount(info);
        return mapper.updateByPrimaryKey(info);
    }

    private void checkUseCount(GroupInfo info) {
        if (StrUtil.equals(Constant.ELEMENT_USE, info.getUse())) {
            GroupInfo groupInfo = new GroupInfo();
            groupInfo.setInMode(info.getInMode());
            groupInfo.setUse(Constant.ELEMENT_USE);
            List<GroupInfo> groupInfos = mapper.selectGroupInfoList(groupInfo);
            groupInfos.forEach(g -> {
                g.setUse(Constant.ELEMENT_NOT_USE);
                mapper.updateByPrimaryKey(g);
            });
        }
    }

    /**
     * 删除集团详情信息
     *
     * @param infoId 集团简介id
     * @return 执行结果 1成功 0失败
     */
    @Override
    public int remove(Long infoId) {
        return mapper.deleteByPrimaryKey(infoId);
    }

    /**
     * 获取首页集团简介
     *
     * @return 集团简介
     */
    @Override
    public GroupInfo getIndexGroupInfo() {
        return mapper.selectIndexGroupInfo();
    }
}
