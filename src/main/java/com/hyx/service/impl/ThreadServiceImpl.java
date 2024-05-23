package com.hyx.service.impl;

import com.hyx.service.ThreadService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class ThreadServiceImpl implements ThreadService {

    private static final Logger log = LoggerFactory.getLogger(ThreadServiceImpl.class);

    private  int count = 3;
    private  double money = 100;
    private double MIN = 0.01;



    @Override
    @Async("ThreadPool")
    public void sendEmail() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("线程中断");
                throw new RuntimeException(e);
            }
            System.out.println("i:" + i);
        }


    }



    }



