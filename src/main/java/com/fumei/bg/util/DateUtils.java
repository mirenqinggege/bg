package com.fumei.bg.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zkh
 */
public class DateUtils {

    public static Date currentTime(){
        return Calendar.getInstance().getTime();
    }

    public static String dateToString(Date date, String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String dateToString(Date date){
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateFilePath(){
        return dateToString(currentTime(),"yyyy/MM/dd");
    }
}
