package com.example.helloworld.entity;

import javax.persistence.*;

/**
 *  Hello world entity
 * @author dongdong.jiang
 * @date 2019/2/20 10:36
 */
@Entity
@Table(name = "hello_world", schema = "adv_hello_world")
public class HelloWorld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String msg;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
