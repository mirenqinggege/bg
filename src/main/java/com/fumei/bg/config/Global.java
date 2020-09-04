package com.fumei.bg.config;

import com.fumei.bg.util.YamlUtil;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置类
 *
 * @author ruoyi
 */
public class Global {
    private static final Logger log = LoggerFactory.getLogger(Global.class);

    private static final String NAME = "application.yml";

    /**
     * 当前对象实例
     */
    private static Global global;

    /**
     * 保存全局属性值
     */
    private static final Map<String, String> MAP = new HashMap<>();

    private Global() {
    }

    /**
     * 静态工厂方法
     */
    public static synchronized Global getInstance() {
        if (global == null) {
            global = new Global();
        }
        return global;
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = MAP.get(key);
        if (value == null) {
            Map<?, ?> yamlMap;
            yamlMap = YamlUtil.loadYaml(NAME);
            value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
            MAP.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }
}
