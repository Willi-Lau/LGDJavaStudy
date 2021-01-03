package com.lwy.Leetcode.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用synchronized 与Lock 区别
 *
 * 线程实时通信时 synchronized 不需要 使用死循环，Lock 需要使用死循环一直监听
 */
public class Thread20201227_1115 {

    public static void main(String[] args) throws InterruptedException {
        FooBar3 fooBar = new FooBar3(5);

        new Thread(()->{
            try {
                fooBar.bar(new Thread(()->{
                    System.out.println("bar");
                }));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooBar.foo(new Thread(()->{
                    System.out.println("foo");
                }));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
class FooBar {

    public Semaphore sema1 = new Semaphore(1);
    public Semaphore sema2 = new Semaphore(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {


        for (int i = 0; i < n; i++) {
            sema1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sema2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sema2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sema1.release();

        }
    }


}

class FooBar2 {

    public volatile boolean flag = false;

    private int n;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {


        for (int i = 0; i < n; i++) {
            synchronized (this){
                while (flag != false){
                    this.wait();
                }

                printFoo.run();
                flag = true;
                this.notifyAll();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (this){
                while (flag != true){
                    this.wait();
                }

                printBar.run();
                flag = false;
                this.notifyAll();
            }

        }
    }


}

class FooBar3 {

    public volatile boolean flag = false;

    Lock lock = new ReentrantLock();

    private int n;

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {


        for (int i = 0; i < n; i++) {

            while (true){
                if(flag == false){
                    try {
                        lock.lock();
                        printFoo.run();
                        flag = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        break;
                    }
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (true){
                if(flag == true) {
                    try {
                        lock.lock();
                        printBar.run();
                        flag = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        break;
                    }
                }

            }

        }
    }


}
