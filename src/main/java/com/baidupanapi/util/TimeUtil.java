package com.baidupanapi.util;

/**
 * Created by xm on 15-11-20.
 */
public class TimeUtil {

    public static String getSecondTime(){
        return String.valueOf(System.currentTimeMillis()).substring(0,10);
    }

}
