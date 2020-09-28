package com.fumei.bg.domain.system;

import java.util.Date;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * file
 * @author zkh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysFile extends BaseEntity {
    /**
     * 主键
     */
    private Long fileId;

    /**
     * 原文件名
     */
    private String originalName;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型
     */
    private String contentType;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件MD5摘要
     */
    private String md5;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否被删除
     */
    private String isDelete;

    private static final long serialVersionUID = 1L;
}