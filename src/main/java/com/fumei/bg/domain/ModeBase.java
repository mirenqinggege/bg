package com.fumei.bg.domain;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ModeBase extends BaseEntity {

    private static final long serialVersionUID = 5660666720983045335L;
    private String title;
    private String titleSm;
}
