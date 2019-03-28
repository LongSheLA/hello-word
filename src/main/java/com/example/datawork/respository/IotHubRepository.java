package com.example.datawork.respository;


import com.example.datawork.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Hello world repository
 */
public interface IotHubRepository extends JpaRepository<MessageEntity, Long>,CustomIotHubRepository {
}
