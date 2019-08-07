package com.example.rabbit;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private UserRepository userRepository;
    public void send(){
        String context = "hello"+new Date();
        System.out.println("Sender:"+context);
        this.amqpTemplate.convertAndSend("object",context);
    }
    public void sendUser(){
        User user = userRepository.findByUserName("aa1");
        System.out.println("Sender:aa1"+user.getUserName()+"\t"+user.getEmail());
        this.amqpTemplate.convertAndSend("object",user);
    }
}
