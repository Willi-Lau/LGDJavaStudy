package com.lwy.JVM;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * jvm stackoverflow outofmenory
 * 通过代码模拟出各种异常
 *
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        /**
         *  StackOverFlowError
         */
        //StackOverflowError();
        /**
         *   java.lang.OutOfMemoryError: Java heap space
         *   -Xmx1m -Xms1m
         */
//        byte[] bytes = new byte[100 * 1024 * 1024];
//         //or
//        String s = "str";
//        while (true){
//            s += UUID.randomUUID().toString().substring(1);
//            s.intern();
//            System.out.println(s);
//        }
        /**
         *      java.lang.OutOfMemoryError: GC overhead limit exceeded
         *    -Xmx10m -Xms10m -XX:MaxDirectMemorySize=5 -XX:+PrintGCDetails
         *    GC回收时间过长，过长的定义是超过 98% 的时间用来做GC并且回收了不到2%的堆内存，连续多次GC都只回收了2%不到的极端情况下才会抛出
         *    日志：
         *      [Full GC (Ergonomics) [PSYoungGen: 2047K->2047K(2560K)] [ParOldGen: 7086K->7086K(7168K)] 9134K->9134K(9728K),
         *                          [Metaspace: 3214K->3214K(1056768K)], 0.0340073 secs]
         *                         可以看到 YoungGC  GC前后空间都不变 都是2047 说明GC有问题
         */
        int i = 0;
        List list = new ArrayList();
        try {
            while(true){
                list.add(String.valueOf(i++).intern());   //.intern() 加入字符串厂常量池
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            System.out.println("**********************8 i:"+i);
        }


    }

    public static void StackOverflowError() {
        StackOverflowError();
    }
}
