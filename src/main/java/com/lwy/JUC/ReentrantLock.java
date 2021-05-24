package com.lwy.JUC;

import com.lwy.test.Test;

import java.util.concurrent.TimeUnit;

/**
 * 可重入锁
 * synchronized ReentrantLock 都是可重入锁
 * 功能：避免死锁
 * 说明 指的是同一函数外层获取锁时候，内层套用方法也可以获取锁
 *    也可以说，线程可以进入任何一个已经拥有锁的同步代码块
 *
 */
public class ReentrantLock {
    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(()->{
            testLock.lock1();
        },"xc1").start();
        new Thread(()->{
             testLock.lock2();
        },"xc2").start();
    }
}

/**
 * 如果线程已经获取lock1() 的锁，那么在进入lock2()  lock3()就不用再获取锁，同理在这期间别人进不去 lock2()  lock3()
 */
class TestLock{
    public synchronized void lock1(){
        System.out.println("lock 1    "+ Thread.currentThread().getName());
        this.lock2();
    }

    public synchronized void lock2(){
        System.out.println("lock 2     " + Thread.currentThread().getName());
        this.lock3();
    }

    public synchronized void lock3(){
        System.out.println("lock 3     " + Thread.currentThread().getName());
    }
}
