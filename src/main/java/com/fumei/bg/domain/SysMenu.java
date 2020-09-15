package com.fumei.bg.domain;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = -1678113523776706457L;

    private Long menuId;
    private Long parentId;
    private String parentIds;
    private Integer orderNum;
    private String name;
    private String link;
    private String target;
    private String icon;
    private String status;
}
