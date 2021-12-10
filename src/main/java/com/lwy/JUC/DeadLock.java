package com.lwy.JUC;


import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 模拟死锁 并且如何通过指令诊断死锁
 * 死锁调试：再idea打开 这个类的 Terminal
 *          jps -l 找到出错线程编号
 *          jstack 刚才查到的编号
 *          然后就可以查询死锁原因了
 */
public class DeadLock {
    static ArrayList<String> list =new ArrayList();
    public static void main(String[] args) {

        while(true){
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());
            list.add(UUID.randomUUID().toString());


        }

//        String lock1 = "lcok1";
//        String lock2 = "lcok2";
//        new Thread(new Lock1(lock1,lock2),"AAA").start();
//        new Thread(new Lock1(lock2,lock1),"BBB").start();
    }
}
class Lock1 implements Runnable{
    private String Lock1;
    private String Lock2;

    public Lock1(String lock1, String lock2) {
        Lock1 = lock1;
        Lock2 = lock2;
    }
    /**
     * 模拟死锁 两个线程相互竞争
     */
    @SneakyThrows
    @Override
    public void run() {
        synchronized (this.Lock1){
            System.out.println(Thread.currentThread().getName()+"自己持有"+Lock1+"尝试获取"+Lock2);
            TimeUnit.SECONDS.sleep(1);
            synchronized (this.Lock2){
                System.out.println(Thread.currentThread().getName()+"自己持有"+Lock2+"尝试获取"+Lock1);
                TimeUnit.SECONDS.sleep(1);
               ThreadLocal l = new ThreadLocal();
            }
        }
    }
}