package com.ruoyi.news.config;

/**
 * 扇形交换机配置类
 *  zzx
 *
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FanoutRabbitConfig {
    /**
     *  创建三个队列 ：fanout.A   fanout.B  fanout.C
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */
    @Bean
    public Queue queueA() {
        return new Queue("fanout.A");
    }
    @Bean
    public Queue queueB() {
        return new Queue("fanout.B");
    }
    @Bean
    public Queue queueC() {
        return new Queue("fanout.C");
    }
    @Bean
    public Queue queueD() {
        return new Queue("fanout.D");
    }
    @Bean
    public Queue queueE() {
        return new Queue("fanout.E");
    }
    @Bean
    public Queue queueF() {
        return new Queue("fanout.F");
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }
    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }
    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }
    @Bean
    Binding bindingExchangeD() {
        return BindingBuilder.bind(queueD()).to(fanoutExchange());
    }
    @Bean
    Binding bindingExchangeE() {
        return BindingBuilder.bind(queueE()).to(fanoutExchange());
    }
    @Bean
    Binding bindingExchangeF() {
        return BindingBuilder.bind(queueF()).to(fanoutExchange());
    }
}