package com.example.helloworld.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  时间处理的工具类
 * @author dongdong.jiang
 * @date 2018/9/20 10:26
 */
public class TimeUtil {

    private static final String  FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间14位<br/>
     * @return String
     */
    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_NORMAL);
        return sdf.format(new Date());
    }

    /**
     * 将UTC时间转成标准的北京时间
     * @param timeStr
     * @return
     * @throws ParseException
     */
    public static String formatTimeString(String timeStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date d = format.parse(timeStr.replace("Z", " UTC"));
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_NORMAL);
        System.out.println(sdf.format(d));
        return sdf.format(d);
    }
}
