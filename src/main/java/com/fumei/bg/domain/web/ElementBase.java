package com.fumei.bg.domain.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ElementBase extends ModeBase {

    private static final long serialVersionUID = 6155602693889331858L;
    private String content;
    private boolean isUse;
}
