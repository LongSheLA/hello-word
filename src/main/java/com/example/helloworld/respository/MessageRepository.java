package com.example.helloworld.respository;


import com.example.helloworld.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Hello world repository
 */
public interface MessageRepository extends JpaRepository<MessageEntity, Long>,CustomMessageRepository {
}
