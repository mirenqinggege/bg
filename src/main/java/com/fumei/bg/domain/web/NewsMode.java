package com.fumei.bg.domain.web;


import lombok.Data;

import java.util.List;

/**
 * @author zkh
 */
@Data
public class NewsMode extends ModeBase{
    private static final long serialVersionUID = 359614599641910743L;
    private List<News> content;
}
