package com.fumei.bg.domain.system;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictType extends BaseEntity {
    private static final long serialVersionUID = 5318004123168361910L;

    private Long dictId;
    private String dictType;
    private String dictName;
    private String isDisabled;
    private String remark;
}
