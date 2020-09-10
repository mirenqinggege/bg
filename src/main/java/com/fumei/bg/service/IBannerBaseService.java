package com.fumei.bg.service;

import com.fumei.bg.domain.BannerBase;

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
}
