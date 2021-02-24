package com.lwy.JUC;

import java.util.concurrent.*;

public class ThreadPoolStudy {
    public static void main(String[] args) {
        /**
         * 工具类最后一个字母都是 S
         * Arrays 数组工具类
         * Collections 集合工具类
         * Executors 线程池工具类
         *
         *
         * 以下三个底层都是ThreadPoolExecutor
         * 线程池和BlockingQueue有关
         */

        ExecutorService pool = Executors.newFixedThreadPool(10);   //一池固定数线程 自己设置
        ExecutorService pool2 = Executors.newSingleThreadExecutor();        //一池一个线程
        ExecutorService pool1 = Executors.newCachedThreadPool();        //一池N线程 根据需求动态变化

        for (int i=0;i<15;i++){
            //线程池工作 参数传递一个线程
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"success");
            });
        }

        //停止
        pool.shutdown();


        /**
         * 线程池7大参数  底层源码
         * public ThreadPoolExecutor(int corePoolSize,    //线程池中常驻核心线程数
         *         int maximumPoolSize,           //线程池最大线程数，此值必须大于1
         *         long keepAliveTime,            //多余线程存活时间，线程池中线程超过corePoolSize ,存活时间超过 keepAliveTime ，多余线程会呗销毁
         *         TimeUnit unit,               //keepAliveTime 的单位
         *         BlockingQueue<Runnable> workQueue,    //任务队列，被提交没有被执行的队列
         *         ThreadFactory threadFactory,           //线程池中的工作工厂，用于创建线程，可以缺省吗，即默认   就是品牌
         *         RejectedExecutionHandler handler)   //拒绝策略 表示队列满了，并且工作线程大于等待线程的最大 线程数时如何拒绝请求执行的Runnable策略 可以缺省
         */


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 5, 1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i=0;i<30;i++)
        poolExecutor.execute(()->{
            System.out.println("hahah         "+ Thread.currentThread().getName());
        });
        poolExecutor.shutdown();

    }
}
