package com.fumei.bg.domain.web;

import lombok.Data;

import java.util.List;

/**
 * @author zkh
 */
@Data
public class TraitMode extends ModeBase {
    private static final long serialVersionUID = 4919184640981902258L;
    private List<Trait> content;
}
