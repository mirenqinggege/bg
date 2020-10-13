package com.fumei.bg.service;

import com.fumei.bg.domain.web.Banner;

import java.util.List;

/**
 * @author zkh
 */
public interface IBannerService {
    /**
     * 保存数据
     * @param banner 数据
     * @return 是否成功 （1成功 0失败）
     */
    int save(Banner banner);

    /**
     * 获取正在使用的banner
     * @return banner集合
     */
    List<Banner> getUseBanner();

    /**
     * 获取广告列表
     * @param banner 广告
     * @return 广告列表
     */
    List<Banner> getBannerList(Banner banner);

    /**
     * 修改广告信息
     * @param banner 广告
     * @return 是否成功 （1成功 0失败）
     */
    int edit(Banner banner);

    /**
     * 删除广告信息
     * @param bannerId 广告id
     * @return 是否成功 （1成功 0失败）
     */
    int remove(Long bannerId);
}
