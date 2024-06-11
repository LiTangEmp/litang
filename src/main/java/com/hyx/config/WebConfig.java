package com.hyx.config;

import com.hyx.interceptors.LoginInterceptor;
import com.hyx.interceptors.RequestLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration  //配置类注解
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private RequestLoggingInterceptor requestLoggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // 注册登录拦截器并排除登录和注册路径
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/user/login","/user/register");
        // 注册请求日志拦截器并排除登录和注册路径
        registry.addInterceptor(requestLoggingInterceptor)
                .excludePathPatterns("");
    }
}
