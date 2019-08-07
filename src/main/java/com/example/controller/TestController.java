package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        User user = userRepository.findByUserName("bb2");
        return user;
    }

    @RequestMapping("/getUserRedis")
    @Cacheable(value = "user-keys")
    public User getUserRedis(){
        User user = userRepository.findByUserName("bb2");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }
    @RequestMapping("/getUsersByUserNameLike")
    public List<User> getUsersByUserNameLike(){
        List<User> users = userRepository.findByUserNameContaining("1");
        return users;
    }
    @RequestMapping("/getUid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null){
            uid = UUID.randomUUID();
            System.out.println("第一次获取UID");
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
