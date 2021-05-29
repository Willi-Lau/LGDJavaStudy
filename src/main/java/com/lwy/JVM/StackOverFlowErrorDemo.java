package com.lwy.JVM;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * jvm stackoverflow outofmenory
 * 通过代码模拟出各种异常
 *
 */
public class StackOverFlowErrorDemo {

    public static void main(final String[] args) {
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
//        int i = 0;
//        List list = new ArrayList();
//        try {
//            while(true){
//                list.add(String.valueOf(i++).intern());   //.intern() 加入字符串厂常量池
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//        finally {
//            System.out.println("**********************8 i:"+i);
//        }
        /**
         * java.lang.OutOfMemoryError: Direct buffer memory
         *写NIO程序经常使用ByteBuffer来读取或者写入数据，这是一种基于通道(Channel)与缓冲区(Buffer)的I/O方式，
         * 它可以使用Native函数库直接分配堆外内存，然后通过一个存储在java堆里面的DirectByteBuffer对象作为这块内存的引用进行操作。
         *
         * ByteBuffer.allocate(capability)是分配JVM堆内存，属于GC管辖范围，由于需要拷贝速度相对较慢。
         * ByteBuffer.allocteDirect(capability)是分配OS本地内存，不属于GC管辖范围，由于不需要内存拷贝所以速度相对较快。
         *
         */

//        System.out.println("配置的maxDirectMemory "+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"mb");
//        ByteBuffer allocate = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        /**
         *
         * 高并发请求服务器，经常出现如下异常：java.lang.OutOfMemoryError: unable to create new native thread
         * 准确的讲native thread异常与对应的平台有关
         *
         * 导致原因：
         *          1.你的应用创建了太多的线程。一个应用进程创建了多个线程，超过系统承载极限
         *          2.你的服务器并不允许你的应用创建这么多的线程，linux系统默认允许单个进程可以创建线程数量为1024个
         * 解决办法：
         *          1.降低线程
         *          2.修改linux服务器配置
         */
//            for(int i=0;;i++){
//                new Thread(()->{
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                },"线程"+i).start();
//            }
        /**
         * java.lang.OutOfMemoryError: Metaspace
         * metaspace 是方法区再hotspot 中实现，他与持久代最大的区别是 metaspace 并不在虚拟机内存中而是使用本地内存，也即再java8中，class metadata,
         * 被存储再metaspace的native memery
         * metaspace中存放了一下信息 = 方法区
             * 虚拟机加载类信息
             * 常量池
             * 静态变量
             * 即时编译后的代码
         *   -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
         */
         int i = 0;
         try {
             while (true){
                 //一直创建类 通过cligb
                 i++;
                 Enhancer enhancer = new Enhancer();
                 enhancer.setSuperclass(OOMTest.class);
                 enhancer.setUseCache(false);
                 enhancer.setCallback(new MethodInterceptor() {

                     @Override
                     public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                         return methodProxy.invokeSuper(o,args);
                     }
                 });
                 enhancer.create();
             }
         }
         catch (Throwable e){
             System.out.println(i);
             e.printStackTrace();
         }

    }
    static class OOMTest {
    }

    public static void StackOverflowError() {
        StackOverflowError();
    }
}
