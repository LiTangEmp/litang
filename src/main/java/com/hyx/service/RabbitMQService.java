package com.hyx.service;

import com.alibaba.fastjson.JSON;
import com.hyx.pojo.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public interface RabbitMQService {

void sendMessage(Message message);
}

