package com.lwy.Java8;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread20210104 {
    /**
     * 规则 增加一个 减少一个 一个一个交替
     */
    public static void main(String[] args) {
//        Shop shop = new Shop();
        Shop4 shop = new Shop4();
        new Thread(()->{
            try {
                for (int i=1 ;i<=10;i++){
                    shop.add();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                for (int i=1 ;i<=10;i++){
                    shop.cut();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"b").start();
        new Thread(()->{
            try {
                for (int i=1 ;i<=10;i++){
                    shop.add();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"c").start();

        new Thread(()->{
            try {
                for (int i=1 ;i<=10;i++){
                    shop.cut();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"d").start();

    }
}

class Shop{
    int num = 0;

    //增加一个 num
    public synchronized void add() throws Exception {
        while(num != 0){
            this.wait();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName()+num);
        this.notifyAll();
    }
    //减少一个num
    public synchronized void cut() throws Exception{
        while(num == 0){
            this.wait();
        }
        num -= 1;
        System.out.println(Thread.currentThread().getName()+num);
        this.notifyAll();
    }
}


class Shop2{
    int num = 0;
    Lock lock = new ReentrantLock();
    Condition add = lock.newCondition();
    Condition cut = lock.newCondition();
    //增加一个 num
    public  void add() {
        lock.lock();
        try {
            while(num != 0){
                //add 等待
                add.await();
            }
            num += 1;
            System.out.println(Thread.currentThread().getName()+num);
            //释放 cut 的权限 唤醒cut
            cut.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //减少一个num
    public  void cut(){
        lock.lock();
        try {
            while(num == 0){
                //等待
                cut.await();
            }
            num -= 1;
            System.out.println(Thread.currentThread().getName()+num);
            //唤醒线程
            add.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


class Shop3{
    volatile int num = 0;
    Semaphore add = new Semaphore(1);
    Semaphore cut = new Semaphore(0);

    //增加一个 num
    public   void add() throws Exception {

            add.acquire();
            num += 1;
            System.out.println(Thread.currentThread().getName()+num);
            cut.release();


    }
    //减少一个num
    public   void cut() throws Exception{

            cut.acquire();
            num -= 1;
            System.out.println(Thread.currentThread().getName()+num);
            add.release();


    }
}

class Shop4{
    int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //增加一个 num
    public  void add() {
        lock.lock();
        try {
            while(num != 0){
                //add 等待
                condition.await();
            }
            num += 1;
            System.out.println(Thread.currentThread().getName()+num);
            //释放 cut 的权限 唤醒cut
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //减少一个num
    public  void cut(){
        lock.lock();
        try {
            while(num == 0){
                //等待
                condition.await();
            }
            num -= 1;
            System.out.println(Thread.currentThread().getName()+num);
            //唤醒线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}