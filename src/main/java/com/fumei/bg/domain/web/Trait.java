package com.fumei.bg.domain.web;

import com.fumei.bg.domain.web.ElementBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Trait extends ElementBase {
    private static final long serialVersionUID = -872422118502933393L;
    private Long traitId;
    private Long fileId;
    private String imgSrc;
}
