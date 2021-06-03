package com.lwy.JUC;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 用于创建锁和其他同步类的基本阻塞原语（阻塞线程）
 *     LockSupport中的park() 和 unpark()作用分别是阻塞线程和解除阻塞线程
 *
 *     LockSupport使用了一种名为Permit(许可) 的概念来做到阻塞和唤醒线程的功能，每一个线程都有一个许可(permit)
 *     permit只有两个值 0和1 默认是0
 *     可以把permit看成是一种Semaphore 只有(0,1) 与信号量不同的是许可证上限就是1
 *
 *     无论是正常的先阻塞后唤醒，还是错误的先唤醒后等待 LockSupport照样支持
 *     synchronized lock 先唤醒后等待就会报错
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        /**
         * 成功
         */
        Thread a = new Thread(()->{
            System.out.println("come in");
            LockSupport.park();  //被阻塞
            System.out.println("唤醒");
        },"A");
        a.start();
        new Thread(()->{
            LockSupport.unpark(a);   //唤醒线程 这里需要传递一个线程进去
            System.out.println("b 唤醒 a");
        },"B").start();

        /**
         * 失败 有多个LockScupport  因为LockSupport上限是1 所以就会出问题
         */
        Thread c = new Thread(()->{
            System.out.println("come in");
            LockSupport.park();  //被阻塞  线程阻塞会消耗 permit 上限超过1报错
            LockSupport.park();  //被阻塞
            System.out.println("唤醒");
        },"C");
        a.start();
        new Thread(()->{
            LockSupport.unpark(c);   //唤醒线程 这里需要传递一个线程进去  增加一个permit 上限是1 累加无效
            LockSupport.unpark(c);   //唤醒线程 这里需要传递一个线程进去
            System.out.println("d 唤醒 c");
        },"D").start();
    }
}
