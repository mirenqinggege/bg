package com.fumei.bg.config;

import com.fumei.bg.interceptor.LoginStatusValidateInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

/**
 * @author zkh
 */
@Configuration
@MapperScan("com.fumei.bg.mapper")
public class Config implements WebMvcConfigurer {
    private final LoginStatusValidateInterceptor loginStatusValidateInterceptor;

    public Config(LoginStatusValidateInterceptor loginStatusValidateInterceptor) {
        this.loginStatusValidateInterceptor = loginStatusValidateInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> list = new ArrayList<>(16);
        list.add("/login");
        list.add("/logout");
        list.add("/reg");
        list.add("/captcha");
        list.add("/checkToken");
        //registry.addInterceptor(loginStatusValidateInterceptor).excludePathPatterns(list);
    }
}
