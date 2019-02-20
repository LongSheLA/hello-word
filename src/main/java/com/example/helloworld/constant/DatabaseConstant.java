package com.example.helloworld.constant;

import java.util.HashMap;
import java.util.Map;

/**
 *  the information to connect the database
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
public class DatabaseConstant {

    public static final String SERVICE = "VCAP_SERVICES";
    public static final String SERVICE_NAME = "postgresql_service_name";
    public static final String SSOURL = "sso_url";
    public static final String SSOVERSION = "v2.0";
    private static Map<String,String> databaseMap;

    static {
        databaseMap = new HashMap<>(16);
        databaseMap.put("dbUserName","postgres");
        databaseMap.put("dbPassword","postgres");
        databaseMap.put("dbUrl","jdbc:postgresql://localhost/apm");
    }

    public static String getDatabaseMapInfo(String key){
        String value = databaseMap.get(key);
        if("".equals(value) || value == null){
            return "暂无查询相应的key值";
        }
        return value;
    }

    public static void setDatabaseMap(String key, String value){
        databaseMap.put(key,value);
    }

    public static void repalceDatabaseMap(String key, String value){
        databaseMap.replace(key, value);
    }
}
