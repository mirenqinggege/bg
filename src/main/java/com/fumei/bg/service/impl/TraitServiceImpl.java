package com.fumei.bg.service.impl;

import com.fumei.bg.common.Constant;
import com.fumei.bg.config.Global;
import com.fumei.bg.domain.web.Trait;
import com.fumei.bg.mapper.TraitMapper;
import com.fumei.bg.service.ITraitService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkh
 */
@Service
public class TraitServiceImpl implements ITraitService {
    private final Short traitUseMaxCount = Short.parseShort(Global.getConfig("WEB.maxTraitCount"));
    private final TraitMapper mapper;

    public TraitServiceImpl(TraitMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 查询特点列表
     *
     * @param trait 条件
     * @return 特点列表
     */
    @Override
    public List<Trait> getTraitList(Trait trait) {
        return mapper.selectTraitList(trait);
    }

    /**
     * 根据id查询特点信息
     *
     * @param traitId 特点id
     * @return 特点信息
     */
    @Override
    public Trait getTrait(Long traitId) {
        return mapper.selectByPrimaryKey(traitId);
    }

    /**
     * 修改特点信息
     *
     * @param trait 特点信息
     * @return 执行结果 1成功  0失败
     */
    @Override
    public int edit(Trait trait) {
        checkUseCount(trait);
        return mapper.updateByPrimaryKey(trait);
    }

    /**
     * 根据id删除特点信息
     *
     * @param traitId 特点id
     * @return 执行结果 1成功  0失败
     */
    @Override
    public int remove(Long traitId) {
        return mapper.deleteByPrimaryKey(traitId);
    }

    /**
     * 保存特点信息
     *
     * @param trait 特点信息
     * @return 执行结果 1成功  0失败
     */
    @Override
    public int insert(Trait trait) {
        checkUseCount(trait);
        return mapper.insert(trait);
    }


    private void checkUseCount(Trait trait) {
        // 如果特点设置为使用状态 开始检查个数
        if (Constant.ELEMENT_USE.equals(trait.getUse())) {
            // 查询正在使用的特点
            Trait t = new Trait();
            t.setUse(Constant.ELEMENT_USE);
            List<Trait> traits = mapper.selectTraitList(t);
            // 如果使用个数大于最大限制
            if (traitUseMaxCount <= traits.size()) {
                Trait trait1 = traits.get(0);
                trait1.setUse(Constant.ELEMENT_NOT_USE);
                // 修改最后一个特点为 未使用
                mapper.updateByPrimaryKey(trait1);
            }
        }
    }
}
