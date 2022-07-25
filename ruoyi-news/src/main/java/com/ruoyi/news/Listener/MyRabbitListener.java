package com.ruoyi.news.Listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"Queue01"})
public class MyRabbitListener {
   // @RabbitHandler
    public void accept(String message){
        System.out.println("接收到消息:"+message);
    }
}
