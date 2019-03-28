package com.example.helloworld.controller;


import com.example.helloworld.entity.MessageEntity;
import com.example.helloworld.service.IiothubService;
import com.example.helloworld.utils.StringUtils;
import com.example.helloworld.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( value = "api/v1")
public class IothubContoller {

    @Autowired
    private IiothubService iiothubService;

    @GetMapping("message")
    public ResponseEntity<?> getMassage(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "startTime", required = false) String startTime,
                                        @RequestParam(value = "endTime", required = false)String endTime){
        if(StringUtils.isBlank(endTime)){
            endTime = TimeUtil.getCurrentTime();
        }

        List<MessageEntity> helloWorld = iiothubService.getMessage(name, startTime, endTime);
        return ResponseEntity.status(HttpStatus.OK).body(helloWorld);
    }
}
