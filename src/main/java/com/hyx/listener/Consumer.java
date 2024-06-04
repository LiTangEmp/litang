package com.hyx.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 消费者类，用于接收并处理消息队列中的消息。
 */
@Component
public class Consumer {


    /**
     * 通过@RabbitListener注解，声明该方法为一个RabbitMQ消息监听器，专门监听名为"messageQueue"的队列。
     * 当队列中有消息时，该方法会被自动调用，用于处理接收到的消息。
     */
    @RabbitListener(queues = "messageQueue")
    public void receiveMessage(String message) {

        if (message != null){
            System.out.println("接收到消息：" + message);
        }else{
            System.out.println("接收到空消息");
        }
    }
}
