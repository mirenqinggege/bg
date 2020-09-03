package com.fumei.bg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fumei.bg.common.BaseEntity;
import lombok.Data;

/**
 * file
 * @author zkh
 */
public class File extends BaseEntity implements Serializable {

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
    private Double fileSize;

    /**
     * 是否被删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        File file = (File) o;
        return Objects.equals(getFileId(), file.getFileId()) &&
                Objects.equals(getOriginalName(), file.getOriginalName()) &&
                Objects.equals(getName(), file.getName()) &&
                Objects.equals(getContentType(), file.getContentType()) &&
                Objects.equals(getFileType(), file.getFileType()) &&
                Objects.equals(getPath(), file.getPath()) &&
                Objects.equals(getFileSize(), file.getFileSize()) &&
                Objects.equals(getCreateTime(), file.getCreateTime()) &&
                Objects.equals(getUpdateTime(), file.getUpdateTime()) &&
                Objects.equals(getIsDelete(), file.getIsDelete());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileId(), getOriginalName(), getName(), getContentType(), getFileType(), getPath(), getFileSize(), getCreateTime(), getUpdateTime(), getIsDelete());
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", originalName='" + originalName + '\'' +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", fileType='" + fileType + '\'' +
                ", path='" + path + '\'' +
                ", fileSize=" + fileSize +
                ", isDelete=" + isDelete +
                '}';
    }
}