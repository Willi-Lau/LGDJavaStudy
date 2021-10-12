package com.lwy.JUC;

import java.util.concurrent.TimeUnit;

/**
 * 学习 interrupter
 * 1. isInterrupted()   打印指定线程的interrupted状态 调用不改变 interrupted状态
 * 2. interrupt()        改变指定线程的interrupted状态
 * 3. 静态 Thread.interrupted()   打印指定线程的interrupted状态 调用清空 interrupted状态
 */
public class InterrupterStudy {

    public static void main(String[] args) throws Exception {

        /**
         * 线程1 打印状态
         */
        Thread t1 = new Thread(()->{
            while (true){

                if(Thread.currentThread().isInterrupted()){
                    System.out.println("----------1打印状态"+Thread.currentThread().isInterrupted());
                    break;
                }

                System.out.println("-----hhh");

                try {
                    TimeUnit.SECONDS.sleep(2);    //等待两秒  这个时候如果在阻塞的状态下修改interrupted 就会报异常
                } catch (InterruptedException e) {
                    System.out.println("------------打印抛出异常的状态"+Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                    Thread.currentThread().interrupt(); //不加这句话会一直打印 ---hhh 因为抛出InterruptedException会重置这个线程的interrupted为false
                    System.out.println("------------打印抛出异常的状态2"+Thread.currentThread().isInterrupted());
                }

            }
        });
            t1.start();
        /**
         * 线程3 1秒后改变状态为true
         */
        new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t1.interrupt();   //改变
                System.out.println("---------------------------改变状态为" + t1.isInterrupted());

            }).start();

        //Thread.interrupted();
        Thread.sleep(5000);
        System.out.println("----------打印程序结束状态"+Thread.currentThread().isInterrupted());
    }
}
