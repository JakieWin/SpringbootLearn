package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/test")
    public String index(){
        return "test success!";
    }
    @RequestMapping("/setUsers")
    public void setUsers(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userRepository.save(new User("aa1","123","aa@qq.com","aa",formattedDate));
        userRepository.save(new User("bb1","123","bb@qq.com","bb",formattedDate));
        userRepository.save(new User("cc1","123","cc@qq.com","cc",formattedDate));

    }
    @RequestMapping("/getUser")
    public User getUser() {
        User user = userRepository.findByUserName("bb1");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return users;
    }
}
