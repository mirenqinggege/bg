package com.fumei.bg.domain.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerBase extends ElementBase {

    private static final long serialVersionUID = 5819686520006339040L;
    private Long bannerId;
    private Long fileId;
    private String bannerSrc;
}
