package com.fumei.bg.domain.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 集团构成
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupComposition extends ElementBase {
    private static final long serialVersionUID = -5078879428913383832L;
    private String imgSrc;
    private Long fileId;
}
