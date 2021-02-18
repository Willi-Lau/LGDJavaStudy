package com.lwy.test;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        TimeUnit.NANOSECONDS.sleep(4);     //4纳秒
        TimeUnit.MICROSECONDS.sleep(4);    //4微秒
        TimeUnit.MILLISECONDS.sleep(4);   //4毫秒
        TimeUnit.SECONDS.sleep(4);  //4s
        TimeUnit.HOURS.sleep(4);    //4小时
        TimeUnit.DAYS.sleep(4);    //4天
        String s ="0123456789";
        System.out.println(s.substring(3,5));

    }
}
