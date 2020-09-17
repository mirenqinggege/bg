package com.fumei.bg.domain.system;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

/**
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = -1678113523776706457L;

    /** 菜单id */
    private Long menuId;
    /** 父菜单id */
    private Long parentId;
    /** 祖级id */
    private String parentIds;
    /** 排序 */
    private Integer orderNum;
    /** 菜单类型（M菜单  B按钮） */
    private String type;
    /** 组件路径 */
    private String component;
    /** 菜单名 */
    private String name;
    /** 路由路径 */
    private String path;
    /** 目标窗口 */
    private String target;
    /** 菜单图标 */
    private String icon;
    /** 菜单状态 */
    private String status;
    /** 子菜单 */
    private ArrayList<SysMenu> child = new ArrayList<>(16);
}
