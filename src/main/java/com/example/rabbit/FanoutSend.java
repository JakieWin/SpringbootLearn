package com.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSend {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send(){
        String context = "Fanout Test";
        System.out.println("Sender:"+context);
        rabbitTemplate.convertAndSend("fanoutExchange","12121",context);
    }
}
