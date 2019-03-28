package com.example.datawork.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.example.datawork.constant.RabbitConstants;
import com.example.datawork.entity.MessageDTO;
import com.example.datawork.entity.MessageEntity;
import com.example.datawork.service.IiothubService;
import com.example.datawork.utils.TimeUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *  Topic receiver
 */
@Component
@RabbitListener(queues = RabbitConstants.CONFIGQUEUENAME)
public class TopicReceiver {

    @Autowired
    private IiothubService iiothubService;

    @RabbitListener(queues = RabbitConstants.CONFIGQUEUENAME, containerFactory="rabbitListenerContainerFactory")
    public void process(String message) {
        System.out.println("Topic Receiver Config  : " + message);

        List<MessageDTO> messageDTOS = JSONObject.parseArray(message, MessageDTO.class);

        List<MessageEntity> messageList = new ArrayList<>(16);
        messageDTOS.forEach(m -> {
            MessageEntity msg = new MessageEntity();
            msg.setName(m.getName());
            msg.setValue(m.getValue());
            msg.setTs(TimeUtil.getCurrentTime());
            messageList.add(msg);
        });

        iiothubService.saveMessage(messageList);
    }
}
