package com.lwy.Java8;

import java.util.concurrent.TimeUnit;

public class TimeUtilStudy {

    public static void main(String[] args) throws Exception {
        TimeUnit.NANOSECONDS.sleep(4);     //4纳秒
        TimeUnit.MICROSECONDS.sleep(4);    //4微秒
        TimeUnit.MILLISECONDS.sleep(4);   //4毫秒
        TimeUnit.SECONDS.sleep(4);  //4s
        TimeUnit.HOURS.sleep(4);    //4小时
        TimeUnit.DAYS.sleep(4);    //4天
    }
}
