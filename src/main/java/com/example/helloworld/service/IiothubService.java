package com.example.helloworld.service;
import com.example.helloworld.entity.MessageEntity;

import java.util.List;

/**
 * Hello world Service
 * @author dongdong.jiang
 * @date 2019/2/20 10:50
 */
public interface IiothubService {

    /**
     * get hello world list
     * @return the result of select
     */
    List<MessageEntity> getMessage();

    /**
     * save message list
     * @param messageList
     * @return
     */
    List<MessageEntity> saveMesage(List<MessageEntity> messageList);
}
