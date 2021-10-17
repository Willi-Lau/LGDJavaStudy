package com.lwy2.ByteDance;

import javax.swing.text.html.HTMLDocument;

public class DeadLock {

    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = "s2";

        new Thread(()->{new Dlock(s1,s2).run();},"Thread A").start();
        new Thread(()->{new Dlock(s2,s1).run();},"Thread B").start();
    }


}

class Dlock implements Runnable{

    String lock1;
    String lock2;

    public Dlock(String lock1,String lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    @Override
    public void run() {


        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+"持有"+lock1+"尝试获取"+lock2);
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"持有"+lock2+"尝试获取"+lock1);
            }

        }
    }
}
