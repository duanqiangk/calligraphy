package com.dqit.calligraphy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author qiang.duan
 * @Date 2021/2/13 21:02
 * @Description
 */
public class DateFormatUtil {
    private static DateFormat yyyyMMddTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String format4Y2M2dHMS (Date date){
        return yyyyMMddTimeFormat.format(date);
    }
}
