package com.lwy.test;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Integer a1 = 128;
        Integer a2 = 128;
        System.out.println(a1 == a2);


        Integer a3 = 127;
        Integer a4 = 127;
        System.out.println(a3 == a4);

        Integer a5 =new Integer(127);
        Integer a6 = new Integer(127);
        System.out.println(a5 == a6);


        Integer a7 = new Integer(127);
        Integer a8 = 127;
        System.out.println(a7 == a8);

        Integer a51 =new Integer(127);
        Integer a61 = new Integer(127);
        System.out.println(a51.intValue() == a61.intValue());


    }
}
