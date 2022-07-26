package com.ruoyi.news.Controller;

import com.ruoyi.news.util.SleepUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**   直连交换机
 * @Author : zzx
 * @CreateTime :
 * @Description :
 **/
@RestController
@RequestMapping("/D_MQ")
@Api(tags = "生产者控制类")
public class SendMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    @Autowired
    SleepUtil sleepUtil;

    //发送直连交换信息 一对一
    @ApiOperation(value = "直连交换生产者发送信息")
    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
//将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange01", "TestDirectRouting", map);
        return "ok";
    }


    //主题交换机
    @ApiOperation(value = "主题交换生产者发送信息键名：topic.man")
    @GetMapping("/sendMan")
    public String sendTopicMessage1(String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }
    @ApiOperation(value = "主题交换生产者发送信息键名：topic.woman")
    @GetMapping("/sendWoman")
    public String sendTopicMessage2(String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
        Map<String, Object> womanMap = new HashMap<>();
        MapPut(womanMap,messageId,"topicExchange","topic.woman",messageData);
        return "ok";
    }


    //扇形交换机
    @ApiOperation(value = "扇形交换生产者发送信息键名：null")
    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage(String  messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
        Map<String, Object> map = new HashMap<>();
        MapPut(map,messageId,"fanoutExchange",null,messageData);

        for (int i=10;i<=20;i++){
            messageData="抢购开始了，商品剩余"+(20-i)+"抢到商品编号为zzx_"+(i-10);
            MapPut(map,messageId,"fanoutExchange",null,messageData);
            sleepUtil.sleep(500);
        }
        MapPut(map,messageId,"fanoutExchange",null,"抢购结束了");
        return "ok";
    }

    //map 方法
public void MapPut( Map<String, Object> map, String messageId ,String Exchange, String routingKey,String messageData)
{
    String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    map.put("messageId", messageId);
    map.put("messageData", messageData);
    map.put("createTime", createTime);
    rabbitTemplate.convertAndSend(Exchange, routingKey, map);
}




}