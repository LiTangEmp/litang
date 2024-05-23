package com.hyx.controller;


import com.hyx.pojo.Result;
import com.hyx.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadSerivce;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @GetMapping("/sendEmail")
    public String sendEmail() {//通过线程池异步实现多线程
            threadPoolTaskExecutor.execute(()->{
                //使用lambda表达式提交一个无返回值的的Runnable任务给线程池threadPoolTaskExecutor
                //.execute方法是ThreadPoolTaskExecutor类中将一个Runnable任务提交到线程池
                try {
                    threadSerivce.sendEmail();
                }catch (Exception e){
                    e.printStackTrace();
                    log.error("邮件发送失败" + e.getMessage());
                }
            });
        return "邮件发送成功";

    }
}
