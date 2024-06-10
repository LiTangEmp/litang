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
 * 利用Spring框架AmqpTemplate来简化消息发送的操作。
 */
@Service
public interface RabbitMQService {

void sendMessage(Message message);
}

