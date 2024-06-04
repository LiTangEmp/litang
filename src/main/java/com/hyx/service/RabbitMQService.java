package com.hyx.service;

import com.alibaba.fastjson.JSON;
import com.hyx.pojo.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用于发送消息到RabbitMQ。
 * 利用Spring框架的AmqpTemplate来简化消息发送的操作。
 */
@Service
public class RabbitMQService {

    private AmqpTemplate amqpTemplate;
    private Jackson2JsonMessageConverter messageConverter;

    @Autowired
    public RabbitMQService(AmqpTemplate amqpTemplate , Jackson2JsonMessageConverter messageConverter) {
        this.amqpTemplate = amqpTemplate;
        this.messageConverter = messageConverter;
    }


    public void sendMessage(Message message) {
        String jsonMessage = JSON.toJSONString(message);//使用FastjsonJSON.toJSONString()序列化消息
        amqpTemplate.convertAndSend("messageQueue", jsonMessage);// 发送消息到名为“messageQueue”消息队列
        System.out.println("发送消息: " + jsonMessage);
    }
}

