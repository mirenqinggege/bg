package com.fumei.bg.domain.web;

import com.fumei.bg.domain.web.ElementBase;
import lombok.Data;

/**
 * @author zkh
 */
@Data
public class Trait extends ElementBase {
    private static final long serialVersionUID = -872422118502933393L;
    private Long traitId;
    private String imgSrc;
}
