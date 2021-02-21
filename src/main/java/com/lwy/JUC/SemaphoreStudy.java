package com.lwy.JUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreStudy {

    public static void main(String[] args) {
        //50个车位
        Semaphore semaphore = new Semaphore(5);
        //100个车抢
        for(int i=0;i<100;i++){
            final int flag = i;
            new Thread(()->{
                try {
                    semaphore.acquire(1);
                    System.out.println(Thread.currentThread().getName()+"获得车位");
                    TimeUnit.SECONDS.sleep(1);
                     System.out.println(Thread.currentThread().getName()+"释放车位********");
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"车"+flag).start();
        }
    }
}
