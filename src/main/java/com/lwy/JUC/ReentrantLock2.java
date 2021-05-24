package com.lwy.JUC;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 可重入锁
 * synchronized ReentrantLock 都是可重入锁
 * 功能：避免死锁
 * 说明 指的是同一函数外层获取锁时候，内层套用方法也可以获取锁
 *    也可以说，线程可以进入任何一个已经拥有锁的同步代码块
 *
 */
public class ReentrantLock2 {
    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(()->{
            testLock.lock1();
        },"xc1").start();
        new Thread(()->{
             testLock.lock2();
        },"xc2").start();

        TestLock2 testLock2 = new TestLock2();
        new Thread(()->{
            testLock2.lock1();
        },"xc1").start();
        new Thread(()->{
            testLock2.lock2();
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

class TestLock2{
     Lock lock = new ReentrantLock();
     Lock lock2 = new ReentrantLock();
     Lock lock3 = new ReentrantLock();
    public  void lock1(){
        lock.lock();
        System.out.println("TestLock2 1    "+ Thread.currentThread().getName());
        this.lock2();
        lock.unlock();
    }

    public  void lock2(){
        lock2.lock();
        System.out.println("TestLock2 2     " + Thread.currentThread().getName());
        this.lock3();
        lock2.unlock();
    }

    public  void lock3(){
        /**
         * 加几把锁 只要能都配对 解锁 都能打开 不会出错  如果不配对 缺了一个unlock() 编译不会出错 运行时会出异常程序执行不全
         */
        lock3.lock();
        lock3.lock();
        System.out.println("TestLock2 3     " + Thread.currentThread().getName());
        lock3.unlock();
        lock3.unlock();

    }
}
