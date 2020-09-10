package com.fumei.bg.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ElementBase extends ModeBase{

    private static final long serialVersionUID = 6155602693889331858L;
    private String content;
    private boolean isUse;
}
