package com.lwy.Java8;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class butticket{

    int ticket = 100;
    Lock lock = new ReentrantLock();

    void buy(){
        lock.lock();
         try {
             if(ticket >0){

             System.out.println(Thread.currentThread().getName()+"卖出第"+ticket--+"票");

             }
         } catch (Exception e) {
             e.printStackTrace();
         } finally {

             lock.unlock();
         }




    }



}
public class LockSpeak {
    public static void main(String[] args) {
        butticket b = new butticket();

        for (int i=0;i<=3;i++){
            new Thread(()->{for (int j=0;j<100;j++) b.buy();},"线程"+i).start();
        }
    }



}
