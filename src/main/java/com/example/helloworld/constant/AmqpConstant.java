package com.example.helloworld.constant;

import java.util.HashMap;
import java.util.Map;

/**
 *  the information to connect the iothub
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
public class AmqpConstant {

    private static Map<String,Object> amqpMap;

    static {
        amqpMap = new HashMap<>(16);
        amqpMap.put("username","admin");
        amqpMap.put("password","admin");
        amqpMap.put("host","127.0.0.1");
        amqpMap.put("vHost","/");
        amqpMap.put("enSSL",false);
        amqpMap.put("port",5672);
    }

    public static Object getAmqpMapInfo(String key){
        Object value = amqpMap.get(key);
        if("".equals(value) || value == null){
            return "暂无查询相应的key值";
        }
        return value;
    }

    public static void setAmqpMap(String key, Object value){
        amqpMap.put(key,value);
    }

    public static void repalceAmqpMap(String key, Object value){
        amqpMap.replace(key, value);
    }
}
