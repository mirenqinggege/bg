package com.fumei.bg.service;

import com.fumei.bg.domain.web.GroupInfo;

import java.util.List;

/**
 * @author zkh
 */
public interface IGroupInfoService {
    /**
     * 查询集团简介信息列表
     * @param info 条件
     * @return 集团简介信息列表
     */
    List<GroupInfo> getGroupInfoList(GroupInfo info);

    /**
     * 保存集团详情信息
     * @param info 集团简介信息
     * @return 执行结果 1成功 0失败
     */
    int save(GroupInfo info);

    /**
     * 修改集团详情信息
     * @param info 集团简介信息
     * @return 执行结果 1成功 0失败
     */
    int edit(GroupInfo info);

    /**
     * 删除集团详情信息
     * @param infoId 集团简介id
     * @return 执行结果 1成功 0失败
     */
    int remove(Long infoId);

    /**
     * 获取首页集团简介
     * @return 集团简介
     */
    GroupInfo getIndexGroupInfo();
}
