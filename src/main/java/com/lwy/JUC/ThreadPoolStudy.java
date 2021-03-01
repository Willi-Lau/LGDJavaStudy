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
               // System.out.println(Thread.currentThread().getName()+"success");
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
         *         ThreadFactory threadFactory,           //线程池中的工作工厂，用于创建线程，可以缺省吗，即默认   就是品牌  Executors.defaultThreadFactory()
         *         RejectedExecutionHandler handler)   //拒绝策略 表示队列满了，并且工作线程大于等待线程的最大 线程数时如何拒绝请求执行的Runnable策略 可以缺省
         */


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 5, 1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i=0;i<30;i++)
            //线程池使用 传入 Runnable
        poolExecutor.execute(()->{
            //System.out.println("hahah         "+ Thread.currentThread().getName());
        });
        //线程池停止
        poolExecutor.shutdown();

        /**
         * 手动创建  普通拒绝策略  默认 MAX 5+6
         */
        ThreadPoolExecutor pool_AbortPolicy = new ThreadPoolExecutor(
                    2,
                    5,
                    2,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(6),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());
        try {
                for (int i=0;i<12;i++)   //最多执行11个 12个就完
                //线程池使用 传入 Runnable
                    pool_AbortPolicy.execute(()->{
                   // System.out.println("hahah "+ Thread.currentThread().getName());
                });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool_AbortPolicy.shutdown();
        }

        /**
         * 手动创建  回滚拒绝策略  默认 MAX 5+6
         */
        ThreadPoolExecutor pool_CallerRunsPolicy = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i=0;i<12;i++)   //当执行的比11多的时候。多的那些线程会被原路遣返，这里这些线程是从主线程来的，所以多余的部分由主线程执行
                //线程池使用 传入 Runnable
                pool_CallerRunsPolicy.execute(()->{
                    //System.out.println("hahah "+ Thread.currentThread().getName());
                });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool_CallerRunsPolicy.shutdown();
        }
/**
 * 手动创建  等待最久丢弃拒绝策略  默认 MAX 5+6
 */
        ThreadPoolExecutor DiscardOldestPolicy = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i=0;i<12;i++)   //当执行的比11多的时候。多的那些线程会被原路遣返，这里这些线程是从主线程来的，所以多余的部分由主线程执行
                //线程池使用 传入 Runnable
                DiscardOldestPolicy.execute(()->{
                    //System.out.println("hahah "+ Thread.currentThread().getName());
                });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DiscardOldestPolicy.shutdown();
        }

        /**
         * 手动创建  所有溢出都丢弃拒绝策略  默认 MAX 5+6
         */
        ThreadPoolExecutor DiscardPolicy = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i=0;i<12;i++)   //当执行的比11多的时候。多的那些线程会被原路遣返，这里这些线程是从主线程来的，所以多余的部分由主线程执行
                //线程池使用 传入 Runnable
                DiscardPolicy.execute(()->{
                    System.out.println("hahah "+ Thread.currentThread().getName());
                });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DiscardPolicy.shutdown();
        }

    }
}
