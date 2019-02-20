package com.example.helloworld.rabbitmq;

import com.example.helloworld.constant.RabbitConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  topic sender
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendConfig(String context) {
        System.out.println("sendConfig Sender : " + context);
        this.rabbitTemplate.convertAndSend(RabbitConstants.EXCHANGENAME, RabbitConstants.CONFIGBINDINGKEY, context);
    }


}