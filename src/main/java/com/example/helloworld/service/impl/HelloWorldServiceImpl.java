package com.example.helloworld.service.impl;

import com.example.helloworld.entity.HelloWorld;
import com.example.helloworld.respository.HelloWorldRepository;
import com.example.helloworld.service.IHelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongdong.jiang
 * @date 2019/2/20 11:07
 */
@Service
public class HelloWorldServiceImpl implements IHelloWorldService {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @Override
    public List<HelloWorld> getHelloWorld(){
        return helloWorldRepository.findAll();
    }

    @Override
    public List<HelloWorld> saveHelloWorld(List<HelloWorld> helloWorldList){
        return helloWorldRepository.saveAll(helloWorldList);
    }
}
