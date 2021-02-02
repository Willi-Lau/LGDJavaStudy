package com.lwy.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println(maxMemory/(double)1024/1024+"MB");

        System.out.println(totalMemory/(double)1024/1024+"MB");
        System.out.println(Runtime.getRuntime().availableProcessors());

        Double d = 15.6d;
        String s = d.toString();
        Double.parseDouble(s);


    }






}
