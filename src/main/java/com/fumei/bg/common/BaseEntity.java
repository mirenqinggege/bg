package com.fumei.bg.common;

import java.util.Date;
import java.util.HashMap;

/**
 * @author zkh
 */
public class BaseEntity extends HashMap<Object, Object> {
    private Date createTime;
    private Date updateTime;
    private HashMap<String, Object> params;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public HashMap<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>(16);
        }
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }
}
