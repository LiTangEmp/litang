package com.hyx.threadtest;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *实现一个简单的定时任务
 * 只是一个大概的使用方法
 **/
@Component
public class ScheduleedTest {

    @Scheduled(fixedRate = 3600000)
    public void printTime(){
        System.out.println("定时任务执行时间：" + System.currentTimeMillis());
    }
}
