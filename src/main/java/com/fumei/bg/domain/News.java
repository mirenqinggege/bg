package com.fumei.bg.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zkh
 */
@Data
public class News extends ElementBase {
    private static final long serialVersionUID = 7026312305589441528L;
    private Long newsId;
    private Date date;
}
