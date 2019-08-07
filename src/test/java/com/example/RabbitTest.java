package com.example;

import com.example.rabbit.FanoutSend;
import com.example.rabbit.HelloSender;
import com.example.rabbit.TopicSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private TopicSend topicSend;
    @Autowired
    private FanoutSend fanoutSend;
    @Test
    public void hello()throws Exception{
//        helloSender.send();
//        helloSender.sendUser();
//        topicSend.send();
//        topicSend.send1();
//        topicSend.send2();
        fanoutSend.send();
    }

}
