package com.lwy.test;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) throws InterruptedException {
     List list = new ArrayList();
     for (int i=0;i<999;i++){
         new Thread(()->{
             list.add(" {"+UUID.randomUUID().toString().substring(0,8)+"} ");
             System.out.println(list);
         },"线程"+Integer.toString(i)).start();
     }




    }
}
