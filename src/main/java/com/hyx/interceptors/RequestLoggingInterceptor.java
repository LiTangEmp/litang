package com.hyx.interceptors;


import com.hyx.pojo.AccessRecord;
import com.hyx.pojo.repository.AccessRecordRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 请求日志拦截器，用于记录HTTP请求的相关信息。
 * 实现HandlerInterceptor接口，以在Spring MVC中拦截请求。
 */
@Slf4j
@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {
    // 使用SLF4J日志框架记录日志
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 请求处理完成后执行的方法。
     * 主要用于记录请求的客户端IP和时间。
     *
     * @param request  HTTP请求对象。
     * @param response HTTP响应对象。
     * @param handler  处理请求的具体对象。
     * @param modelAndView 视图模型对象。
     * @throws Exception 处理过程中发生异常，会抛出此异常。
     */

    @Autowired
    private AccessRecordRepository accessRecordRepository;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 获取客户端IP地址
        String clientIp = request.getRemoteAddr();
        // 记录请求完成的时间
        logger.info("Request from IP: {} at {}", clientIp, LocalDateTime.now());
        AccessRecord record = new AccessRecord();
        record.setClientIp(clientIp);
        record.setAccessTime(LocalDateTime.now());
        accessRecordRepository.save(record);
    }
}

