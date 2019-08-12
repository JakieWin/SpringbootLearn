package com.example.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {
    private int count = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(cron = "* */1 * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing "+(count++));
    }
    @Scheduled(fixedRate = 1000)
    private void process2(){
        System.out.println("现在时间是"+dateFormat.format(new Date()));
    }
}
