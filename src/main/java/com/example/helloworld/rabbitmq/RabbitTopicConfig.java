package com.example.helloworld.rabbitmq;

import com.example.helloworld.constant.AmqpConstant;
import com.example.helloworld.constant.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  RabbitMQ server config
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
@Configuration
public class RabbitTopicConfig {

    /**
     * create rabbit connect factory
     * @return rabbit connection factory
     */
    @Bean(name = "helloWorldConnectionFactory")
    public ConnectionFactory connectionFactory() {
        System.out.println("***************初始化rabbit 连接");
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername((String)AmqpConstant.getAmqpMapInfo("username"));
        connectionFactory.setPassword((String)AmqpConstant.getAmqpMapInfo("password"));
        connectionFactory.setHost((String)AmqpConstant.getAmqpMapInfo("host"));
        connectionFactory.setPort((Integer) AmqpConstant.getAmqpMapInfo("port"));
        connectionFactory.setVirtualHost((String) AmqpConstant.getAmqpMapInfo("vHost"));
        System.out.println(connectionFactory.toString());
        return connectionFactory;
    }

    /**
     * create a queue
     * @return queue
     */
    @Bean(name = "helloWorldConfig")
    public Queue queueConfig() {
        return new Queue(RabbitConstants.CONFIGQUEUENAME);
    }

    /**
     * create topic exchange
     * @return topic exchange
     */
    @Bean(name = "helloWorldExchange")
    public TopicExchange exchange() {
        return new TopicExchange(RabbitConstants.EXCHANGENAME);
    }

    /**
     * bind the queue and exchange thought key
     * @param queueConfig queue
     * @param exchange exchange
     * @return
     */
    @Bean
    public Binding bindingExchangeConfig(@Qualifier("helloWorldConfig")Queue queueConfig, @Qualifier("helloWorldExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queueConfig).to(exchange).with(RabbitConstants.CONFIGBINDINGKEY);
    }

}