package com.fumei.bg.service.impl;

import com.fumei.bg.config.Global;
import com.fumei.bg.domain.web.BannerBase;
import com.fumei.bg.mapper.BannerBaseMapper;
import com.fumei.bg.service.IBannerBaseService;
import com.fumei.bg.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class BannerBaseServiceImpl implements IBannerBaseService {
    private final Short maxBannerCount = Short.parseShort(Global.getConfig("Banner.maxBannerCount"));
    private final BannerBaseMapper mapper;

    public BannerBaseServiceImpl(BannerBaseMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 保存数据
     *
     * @param bannerBase 数据
     * @return 是否成功 （1成功 0失败）
     */
    @Override
    public int save(BannerBase bannerBase) {
        bannerBase.setCreateTime(DateUtils.currentTime());
        List<BannerBase> bannerBases = mapper.selectByUse();
        if(bannerBases.size() > maxBannerCount){
            BannerBase bannerBase1 = bannerBases.get(maxBannerCount - 1);
            mapper.updateById(bannerBase1);
        }
        return mapper.insert(bannerBase);
    }

    /**
     * 获取正在使用的banner
     *
     * @return banner集合
     */
    @Override
    public List<BannerBase> getUseBanner() {
        return mapper.selectByUse();
    }

    /**
     * 获取广告列表
     *
     * @param banner 广告
     * @return 广告列表
     */
    @Override
    public List<BannerBase> getBannerList(BannerBase banner) {
        return mapper.selectBannerList(banner);
    }

    /**
     * 修改广告信息
     *
     * @param banner 广告
     * @return 是否成功 （1成功 0失败）
     */
    @Override
    public int edit(BannerBase banner) {
        return mapper.updateById(banner);
    }

    /**
     * 删除广告信息
     *
     * @param bannerId 广告id
     * @return 是否成功 （1成功 0失败）
     */
    @Override
    public int remove(Long bannerId) {
        return mapper.deleteByPrimaryKey(bannerId);
    }
}
