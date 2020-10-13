package com.fumei.bg.service.impl;

import com.fumei.bg.common.Constant;
import com.fumei.bg.config.Global;
import com.fumei.bg.domain.web.Banner;
import com.fumei.bg.mapper.BannerMapper;
import com.fumei.bg.service.IBannerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class BannerServiceImpl implements IBannerService {
    private final Short maxBannerCount = Short.parseShort(Global.getConfig("WEB.maxBannerCount"));
    private final BannerMapper mapper;

    public BannerServiceImpl(BannerMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 保存数据
     *
     * @param banner 数据
     * @return 是否成功 （1成功 0失败）
     */
    @Override
    public int save(Banner banner) {
        checkUseCount(banner);
        return mapper.insert(banner);
    }

    private void checkUseCount(Banner banner) {
        if (Constant.ELEMENT_USE.equals(banner.getUse())) {
            // 查询已经是使用状态的广告
            List<Banner> banners = mapper.selectByUse();
            // 如果正在使用的广告数大于最多使用数
            if (banners.size() > maxBannerCount) {
                // 获取最后一个广告
                Banner banner1 = banners.get(0);
                // 设置这个广告为 未使用
                banner1.setUse(Constant.ELEMENT_NOT_USE);
                // 提交数据库
                mapper.updateById(banner1);
            }
        }
    }

    /**
     * 获取正在使用的banner
     *
     * @return banner集合
     */
    @Override
    public List<Banner> getUseBanner() {
        return mapper.selectByUse();
    }

    /**
     * 获取广告列表
     *
     * @param banner 广告
     * @return 广告列表
     */
    @Override
    public List<Banner> getBannerList(Banner banner) {
        return mapper.selectBannerList(banner);
    }

    /**
     * 修改广告信息
     *
     * @param banner 广告
     * @return 是否成功 （1成功 0失败）
     */
    @Override
    public int edit(Banner banner) {
        checkUseCount(banner);
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
