package com.fumei.bg.domain.system;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysDictData extends BaseEntity {

    private static final long serialVersionUID = -6896056769885062949L;

    private Long dataId;
    private String dictType;
    private String label;
    private String value;
    private String remark;
}
