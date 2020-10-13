package com.fumei.bg.domain.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Partner extends ElementBase {
    private static final long serialVersionUID = 503084577170558952L;
    private Long pId;
    private String logoSrc;
    private Long fileId;
}
