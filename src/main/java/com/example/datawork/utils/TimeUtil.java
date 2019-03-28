package com.example.datawork.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeUtil {

    private static final String  FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";


    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_NORMAL);
        return sdf.format(new Date());
    }


    public static String formatTimeString(String timeStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date d = format.parse(timeStr.replace("Z", " UTC"));
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_NORMAL);
        System.out.println(sdf.format(d));
        return sdf.format(d);
    }
}
