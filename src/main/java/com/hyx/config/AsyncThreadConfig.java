package com.hyx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建并配置一个线程池，用于处理任务。
 *
 * @return Executor 返回配置好的线程池实例。
 */

@Configuration
@EnableAsync
public class AsyncThreadConfig {

    @Bean("ThreadPool")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        //创建ThreadPoolTaskExecutor实例
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);//核心线程数10
        threadPoolTaskExecutor.setMaxPoolSize(20);//最大线程数20
        threadPoolTaskExecutor.setQueueCapacity(200);//队列容量200
        threadPoolTaskExecutor.setKeepAliveSeconds(60);//线程空闲时间60秒
//        executor.setThreadNamePrefix("ThreadPool-");//线程名称前缀
        //丢弃队列中最老的任务
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolTaskExecutor.initialize();//初始化线程池
        return threadPoolTaskExecutor;
    }
}
