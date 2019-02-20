package com.example.helloworld.service;

import com.example.helloworld.entity.HelloWorld;

import java.util.List;

/**
 * Hello world Service
 * @author dongdong.jiang
 * @date 2019/2/20 10:50
 */
public interface IHelloWorldService  {

    /**
     * get hello world list
     * @return the result of select
     */
    List<HelloWorld> getHelloWorld();


    /**
     *  save hello word by list type
     * @param helloWorldList
     * @return
     */
    List<HelloWorld> saveHelloWorld(List<HelloWorld> helloWorldList);
}
