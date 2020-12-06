package com.lwy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LambdaStudy {


    //Lambda 口诀 拷贝小括号，写死右箭头，落地大括号

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        //普通线程实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread.currentThread().getName() 获取线程名字
                    System.out.println(Thread.currentThread().getName()+"启动");

            }
        },"线程1").start();

        //lambda 实现线程
        // () 写入参数
        // {} 写入实现
        new Thread(()->{ System.out.println(Thread.currentThread().getName()+"启动");},"线程2").start();

    }
}
