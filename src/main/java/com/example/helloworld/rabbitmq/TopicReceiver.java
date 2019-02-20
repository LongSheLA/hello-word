package com.example.helloworld.rabbitmq;

import com.example.helloworld.constant.RabbitConstants;
import com.example.helloworld.entity.HelloWorld;
import com.example.helloworld.service.IHelloWorldService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *  topic receiver
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
@Component
@RabbitListener(queues = RabbitConstants.CONFIGQUEUENAME)
public class TopicReceiver {

    @Autowired
    private IHelloWorldService iHelloWorldService;

    @RabbitListener(queues = RabbitConstants.CONFIGQUEUENAME, containerFactory="rabbitListenerContainerFactory")
    public void process(String message) {
        System.out.println("Topic Receiver Config  : " + message);
        List<HelloWorld> lists = new ArrayList<>(16);
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMsg(message);
        lists.add(helloWorld);
        iHelloWorldService.saveHelloWorld(lists);
    }
}
