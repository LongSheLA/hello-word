package com.example.helloworld;

import com.example.helloworld.rabbitmq.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldApplicationTests {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void contextLoads() {
        topicSender.sendConfig("hello world");

    }

}
