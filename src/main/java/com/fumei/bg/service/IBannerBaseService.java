package com.fumei.bg.service;

import com.fumei.bg.domain.web.BannerBase;

import java.util.List;

/**
 * @author zkh
 */
public interface IBannerBaseService {
    /**
     * 保存数据
     * @param bannerBase 数据
     * @return 是否成功 （1成功 0失败）
     */
    int save(BannerBase bannerBase);

    /**
     * 获取正在使用的banner
     * @return banner集合
     */
    List<BannerBase> getUseBanner();

    /**
     * 获取广告列表
     * @param banner 广告
     * @return 广告列表
     */
    List<BannerBase> getBannerList(BannerBase banner);

    /**
     * 修改广告信息
     * @param banner 广告
     * @return 是否成功 （1成功 0失败）
     */
    int edit(BannerBase banner);

    /**
     * 删除广告信息
     * @param bannerId 广告id
     * @return 是否成功 （1成功 0失败）
     */
    int remove(Long bannerId);
}
