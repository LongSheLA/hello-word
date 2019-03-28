package com.example.datawork.service;
import com.example.datawork.entity.MessageEntity;

import java.util.List;

/**
 * Hello world Service
 * @author dongdong.jiang
 * @date 2019/2/20 10:50
 */
public interface IiothubService {

    /**
     * select received message by name or startTime or endTime
     * @param name  the name of message
     * @param startTime ts
     * @param endTime ts
     * @return the result of select
     */
    List<MessageEntity> getMessage(String name, String startTime, String endTime);

    /**
     * save message
     * @param messageList
     * @return
     */
    List<MessageEntity> saveMessage(List<MessageEntity> messageList);
}
