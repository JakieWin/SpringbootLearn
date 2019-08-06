package com.example.repository;

import com.example.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest  {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test()throws Exception{
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa1","123","aa@163.com","aa",formattedDate));
//        userRepository.save(new User("bb2","123","bb@163.com","bb",formattedDate));
//        userRepository.save(new User("cc3","123","cc@163.com","cc",formattedDate));

        //可以通过比较期待值和查询值，来确定测试是否通过
        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb2","").getNickName());

        userRepository.delete(userRepository.findByUserName("cc3"));
    }
}
