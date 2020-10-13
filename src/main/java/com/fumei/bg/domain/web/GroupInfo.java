package com.fumei.bg.domain.web;

import com.fumei.bg.domain.web.ElementBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 集团简介
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupInfo extends ElementBase {
    private static final long serialVersionUID = 5123818404759565920L;
    private Long infoId;
    private String inMode;
    private Long fileId;
    private String imgSrc;
}
