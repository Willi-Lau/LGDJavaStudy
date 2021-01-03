package com.lwy.Leetcode.Thread;

import java.util.concurrent.CountDownLatch;
/**
 * Leecode 1114.按顺序打印   使用JUC解决
 */
public class Thread20201226_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        Foo2 foo = new Foo2();

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
class Foo2 {

    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);
    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
