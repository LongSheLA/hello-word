package com.example.helloworld.respository;

import com.example.helloworld.entity.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Hello world repository
 * @author dongdong.jiang
 * @date 2019/2/20 10:46
 */
public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {
}
