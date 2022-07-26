package com.ruoyi.news.Listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * zzx
 *直连交换机 消费者队列Queue01
 *
 */
@Component
//消息队列名称
@RabbitListener(queues = "Queue01")
public class QueueReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("Queue01消费者收到消息  : " +testMessage.toString());
    }

}

