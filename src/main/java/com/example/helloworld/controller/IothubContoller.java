package com.example.helloworld.controller;


import com.example.helloworld.entity.MessageEntity;
import com.example.helloworld.service.IiothubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  Hello world controller
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
@RestController
public class IothubContoller {

    @Autowired
    private IiothubService iiothubService;

    @GetMapping("hello")
    public ResponseEntity<?> getMassage(){
        List<MessageEntity> helloWorld = iiothubService.getHelloWorld();
        return ResponseEntity.status(HttpStatus.OK).body(helloWorld);
    }
}
