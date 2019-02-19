package com.example.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
@RestController
public class HelloworldContoller {

    @GetMapping("hello")
    public ResponseEntity<?> getMassage(){
        return ResponseEntity.status(HttpStatus.OK).body("hello world");
    }
}
