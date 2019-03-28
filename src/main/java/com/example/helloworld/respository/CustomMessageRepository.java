package com.example.helloworld.respository;

import com.example.helloworld.entity.MessageEntity;

import java.util.List;

/**
 * We can custom a repository to implement special select
 */
public interface CustomMessageRepository {

    /**
     * select received message by name or startTime or endTime
     * @param name  the name of message
     * @param startTime ts
     * @param endTime ts
     * @return the result of select
     */
    List<MessageEntity> findMessageByNameOrTime(String name, String startTime, String endTime);
}
