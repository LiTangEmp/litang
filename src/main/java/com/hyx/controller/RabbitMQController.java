package com.hyx.controller;

import com.hyx.pojo.Message;
import com.hyx.service.RabbitMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * RabbitMQController用于处理与RabbitMQ相关的HTTP请求。
 * 通过RabbitMQService向RabbitMQ发送消息。
 */
@Slf4j
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    private final RabbitMQService rabbitMQService;

    @Autowired
    public RabbitMQController(RabbitMQService rabbitMQService) {//构造函数注入RabbitMQService
        this.rabbitMQService = rabbitMQService;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
    //检查是否为空
        if (message == null || message.getContent() == null || message.getContent().isEmpty()){
            return ResponseEntity.badRequest().body("消息不能为空");
        }
        try {
            log.info("开始发送消息：{}", message);
            rabbitMQService.sendMessage(message);
            log.info("发送消息成功：{}", message);
            return ResponseEntity.ok("发送消息成功");
        }catch (Exception e){
            e.printStackTrace();
            log.info("发送消息失败：{}", message);
            return ResponseEntity.badRequest().body("发送消息失败");
        }
    }
}

