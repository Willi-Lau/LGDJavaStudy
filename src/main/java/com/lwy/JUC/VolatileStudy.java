package com.lwy.JUC;


import java.util.concurrent.TimeUnit;

/**
 * 证明 volatile 可见性
 */
public class VolatileStudy {

    public static volatile int flag = 0;
    //public static  int flag = 0;

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = 100;
        }).start();


        while(flag != 100){

        }

        System.out.println("over");
    }
}
