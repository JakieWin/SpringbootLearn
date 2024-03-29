package com.example.rabbit;

import com.example.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//需要监听发送方所填写的队列名称
@RabbitListener(queues="objectI")
@RabbitListener(queues = "hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:"+hello);
    }
    @RabbitHandler
    public void process(User user){
        System.out.println("Receiver:aa1"+user+user.getUserName()+"\t"+user.getEmail());
    }
}
