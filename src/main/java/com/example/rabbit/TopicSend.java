package com.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSend {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send(){
        String context = "Hi,I'm message for topic.message";
        System.out.println("Sender 1:"+context);
        rabbitTemplate.convertAndSend("exchange","topic.message",context);
    }
    public void send1(){
        String context = "Hi,I'm message for topic.1";
        System.out.println("Sender 2:"+context);
        rabbitTemplate.convertAndSend("exchange","topic.1",context);
    }
    public void send2(){
        String context = "Hi,I'm message for topic.messages";
        System.out.println("Sender 3:"+context);
        rabbitTemplate.convertAndSend("exchange","topic.messages",context);
    }
}
