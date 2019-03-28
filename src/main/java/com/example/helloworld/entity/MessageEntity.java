package com.example.helloworld.entity;

import javax.persistence.*;

/**
 *  Hello world entity
 * @author dongdong.jiang
 * @date 2019/2/20 10:36
 */
@Entity
@Table(name = "t_message_entity", schema = "s_iot_hub_test")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String value;

    private String ts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
