package com.example.helloworld.utils;

/**
 * String Utils
 */
public class StringUtils {

    /**
     *  validate String
     * @param str the string needed to validated
     * @return true or false
     */
    public static Boolean isBlank(String str){
        if(str == null ||"".equals(str)){
            return true;
        }else{
            return false;
        }
    }
}
