package com.example.helloworld.service.impl;

import com.example.helloworld.entity.MessageEntity;
import com.example.helloworld.respository.MessageRepository;
import com.example.helloworld.service.IiothubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongdong.jiang
 * @date 2019/2/20 11:07
 */
@Service
public class IothubServiceImpl implements IiothubService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<MessageEntity> getMessage(String name, String startTime, String endTime){
        return messageRepository.findMessageByNameOrTime(name,startTime, endTime);
    }


    @Override
    public List<MessageEntity> saveMessage(List<MessageEntity> helloWorldList){
        return messageRepository.saveAll(helloWorldList);
    }
}
