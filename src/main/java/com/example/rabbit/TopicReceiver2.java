package com.example.rabbit;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.2")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String context){
        System.out.println("Receiver messages:"+context);
    }
}
