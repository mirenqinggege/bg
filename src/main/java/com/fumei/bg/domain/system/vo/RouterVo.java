package com.fumei.bg.domain.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zkh
 */
@Data
public class RouterVo {
    /** 路由地址 */
    private String path;
    /** 组件路径 */
    private String component;
    /** 路由名称 */
    private String name;
    /** child 大于 1  */
    private Boolean alwaysShow;
    /** 子路由 */
    private List<RouterVo> children;
}
