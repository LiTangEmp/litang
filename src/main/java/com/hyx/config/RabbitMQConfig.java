package com.hyx.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMQ 配置类
 */
@Configuration
public class RabbitMQConfig {


    // 创建一个队列
    @Bean
    public Queue messageQueue() {
        return new Queue("messageQueue", true);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // 创建一个监听容器工厂用于消费者

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory , Jackson2JsonMessageConverter converter) {
        //创建实例
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        //设置连接工厂
        factory.setConnectionFactory(connectionFactory);
        //设置消息转换器，基于Jackson库来处理JSON的序列化和反序列化
        factory.setMessageConverter(converter);
        return factory;
    }
}
