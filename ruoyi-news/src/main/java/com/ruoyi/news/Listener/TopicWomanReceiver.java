package com.ruoyi.news.Listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 *
 * zzx
 *主题交换机消费者woman
 *
 */
@Component
@RabbitListener(queues = "topic.woman")
public class TopicWomanReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicWomanReceiver消费者收到消息  : " + testMessage.toString());
    }
}