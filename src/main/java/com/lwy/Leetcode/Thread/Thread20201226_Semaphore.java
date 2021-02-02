package com.lwy.Leetcode.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Leecode 1114.按顺序打印
 */
public class Thread20201226_Semaphore {


    public static void main(String[] args) throws InterruptedException {
        Foo3 foo = new Foo3();

       foo.first(new Thread(()->{
           System.out.println("one");
       }));
       foo.second(new Thread(()->{
           System.out.println("two");
       }));
       foo.third(new Thread(()->{
           System.out.println("three");
       }));


    }

}

class Foo {
    /**
     * Semaphore 是juc下一个线程工具，synchronized lock只能锁一个，Semaphore允许同一时间多个线程对其进行访问
     * new Semaphore（num） 规定同时允许num个数量的线程同时访问
     *                      如果num是0，就需要先使用release()对资源进行释放，在进行权限获取acquire()
     * release() 释放一个许可 释放执行的许可  不一定获取了才能释放
     * acquire() 获取一个许可 获取许可才可以执行
     * */
    // 现在许可证数量是0
    public Semaphore sema_one = new Semaphore(0);
    // 现在许可证数量是0
    public Semaphore seam_two = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        //给sema_one 增加一个许可证数量，这样别人才可以获取
        sema_one.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //获取sema_one许可
        sema_one.acquire();
        printSecond.run();
        //给sema_two 增加一个许可证数量，这样别人才可以获取
        seam_two.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        //获取sema_two许可
        seam_two.acquire();
        printThird.run();
    }
}

/**
 * wait notifyall 只能和synchronized一起用吧，不能和lock一起用
 * wait 当前线程停止
 * notifyall 释放所有资源
 */
class Foo3 {
    private Object object = new Object();
    private volatile int flag = 1;
    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) {
                object.wait();
            }

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) {
                object.wait();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) {
                object.wait();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            object.notifyAll();
        }
    }
}

/**
 * ReentrantLock 实现线程通信
 */
class Foo4 {
    private volatile int flag = 1;
    private ReentrantLock reentrantLock = new ReentrantLock();
    public Foo4() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        for (;;) {
            if (flag == 1) {
                reentrantLock.lock();
                break;
            }
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
        reentrantLock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        for (;;) {
            if (flag == 2) {
                reentrantLock.lock();
                break;
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
        reentrantLock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        for (;;) {
            if (flag == 3) {
                reentrantLock.lock();
                break;
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        reentrantLock.unlock();
    }
}