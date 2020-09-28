package com.fumei.bg.domain.system;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysIcon extends BaseEntity {
    private static final long serialVersionUID = 4249874244943776539L;

    private Long iconId;
    private String className;
}
