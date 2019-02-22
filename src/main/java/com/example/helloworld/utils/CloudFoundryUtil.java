package com.example.helloworld.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.helloworld.constant.AmqpConstant;
import com.example.helloworld.constant.DatabaseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * get database information from env
 * @author dongdong.jiang
 * @date 2018/9/7 10:09
 */
public class CloudFoundryUtil {

    private static Logger log = LoggerFactory.getLogger(CloudFoundryUtil.class);

    public static void getDatabaseFromSystemVariables(){
        System.out.println("*********开始读取环境变量*********");
        String service = System.getenv(DatabaseConstant.SERVICE);
        String serviceName = System.getenv(DatabaseConstant.SERVICE_NAME);
        if( !"".equals(service) && service != null ){
            JSONObject json = JSONObject.parseObject(service);
            JSONObject credentials = json.getJSONArray(serviceName).getJSONObject(0).getJSONObject("credentials");
            String dbUserName = credentials.getString("username");
            String dbPassword = credentials.getString("password");
            String dbDatabase = credentials.getString("database");
            log.info(dbDatabase);
            log.info(dbPassword);
            log.info(dbUserName);
            String dbUrl = String.format("jdbc:postgresql://%s:%d/%s", credentials.getString("host"),
                    credentials.getIntValue("port"), credentials.getString("database"));
            DatabaseConstant.repalceDatabaseMap("dbUserName",dbUserName);
            DatabaseConstant.repalceDatabaseMap("dbPassword",dbPassword);
            DatabaseConstant.repalceDatabaseMap("dbUrl",dbUrl);
            JSONArray jsonArray = json.getJSONArray("p-rabbitmq");
            JSONObject protocols = jsonArray.getJSONObject(0).getJSONObject("credentials").getJSONObject("protocols");

            String host = "";
            String vHost = "";
            String username = "";
            String password = "";
            boolean enSSL = false;
            Integer port = 5672;
            String amqpssl = "amqp+ssl";
            String amqp = "amqp";
            if(protocols.containsKey(amqpssl)){
                enSSL = true;
                JSONObject amqpjson  = protocols.getJSONObject("amqp+ssl");
                log.info("[2]-amqpjson:" + amqpjson);
                vHost = amqpjson.getString("vhost");
                username = amqpjson.getString("username");
                password = amqpjson.getString("password");
                host = amqpjson.getString("host");
                port = amqpjson.getInteger("port");
            }else if(protocols.containsKey(amqp)){
                JSONObject amqpjson  = protocols.getJSONObject("amqp");
                log.info("[2]-amqpjson:" + amqpjson);
                vHost = amqpjson.getString("vhost");
                username = amqpjson.getString("username");
                password = amqpjson.getString("password");
                host = amqpjson.getString("host");
                port = amqpjson.getInteger("port");
            }
            AmqpConstant.repalceAmqpMap("username",username);
            AmqpConstant.repalceAmqpMap("password",password);
            AmqpConstant.repalceAmqpMap("host",host);
            AmqpConstant.repalceAmqpMap("vHost",vHost);
            AmqpConstant.repalceAmqpMap("enSSL",enSSL);
            AmqpConstant.repalceAmqpMap("port",port);
        }
    }
}
