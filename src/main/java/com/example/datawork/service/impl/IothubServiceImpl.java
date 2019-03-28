package com.example.datawork.service.impl;

import com.example.datawork.entity.MessageEntity;
import com.example.datawork.respository.IotHubRepository;
import com.example.datawork.service.IiothubService;
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
    private IotHubRepository iothubRepository;

    @Override
    public List<MessageEntity> getMessage(String name, String startTime, String endTime){
        return iothubRepository.findMessageByNameOrTime(name,startTime, endTime);
    }


    @Override
    public List<MessageEntity> saveMessage(List<MessageEntity> helloWorldList){
        return iothubRepository.saveAll(helloWorldList);
    }
}
