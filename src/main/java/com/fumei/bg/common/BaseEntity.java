package com.fumei.bg.common;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zkh
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 8622501659705817175L;
    private Date createTime;
    private Date updateTime;
    private Map<String, Object> params = new HashMap<>(16);
}
