package com.fumei.bg.domain.web;

import com.fumei.bg.domain.web.ElementBase;
import lombok.Data;

/**
 * 集团简介
 * @author zkh
 */
@Data
public class InfoBase extends ElementBase {
    private static final long serialVersionUID = 5123818404759565920L;
    private Long infoId;
    private String imgSrc;
}
