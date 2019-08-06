package com.example.demo;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test()throws Exception{
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate =dateFormat.format(date);

        userRepository.save(new User("aa1","123","aa@qq.com","jk",formattedDate));
        userRepository.save(new User("bb1","123","bb@qq.com","jk",formattedDate));
        userRepository.save(new User("cc1","123","cc@qq.com","jk",formattedDate));

        Assert.assertEquals("bb2",userRepository.findByUserNameOrEmail("bb","xxxqq.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));

    }
}
