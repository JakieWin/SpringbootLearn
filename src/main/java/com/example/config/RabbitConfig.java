package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue Queue(){
        return new Queue("hello");
    }
    @Bean
    public Queue objectO(){
        //这是创建的队列名称
        return new Queue("objectI");
    }
}
