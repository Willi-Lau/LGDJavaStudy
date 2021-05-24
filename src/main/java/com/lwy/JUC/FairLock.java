package com.lwy.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 公平锁非公平锁
 * lock 默认非公平锁  synchronized 非公平锁
 *
 * 非公平锁效率好 吞吐量比公平锁大
 */
public class FairLock {
    public static void main(String[] args) {
        //非公平锁
        //允许加塞 先上来就加塞，失败再公平的等待
        Lock lock = new ReentrantLock();
        { synchronized (FairLock.class){ } }
        //公平锁
        //先来后到 谁先来谁先进来
        Lock lock2 = new ReentrantLock(true);
    }
}
