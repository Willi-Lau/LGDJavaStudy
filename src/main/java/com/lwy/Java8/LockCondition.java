package com.lwy.Java8;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 要求
 *
 *  AA 打印5次  BB打印10次  CC打印15次   执行10轮
 */
public class LockCondition {

    public static void main(String[] args) {
        LockConditionSpeak speak = new LockConditionSpeak();
        new Thread(()->{for (int i=0;i<10;i++)speak.speak5();},"线程1").start();
        new Thread(()->{for (int i=0;i<10;i++)speak.speak10();},"线程2").start();
        new Thread(()->{for (int i=0;i<10;i++)speak.speak15();},"线程3").start();
    }
}

class LockConditionSpeak{
    private Lock lock = new ReentrantLock();
    private volatile int flag = 1;  //   1 a   2 b    3c
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    
    public void speak5(){
        lock.lock();
        try {
            //判断
            while(flag != 1){
                c1.await();
            }
            //做工
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //跳转
            flag =2;
            c2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
    }

    public void speak10(){
        lock.lock();
        try {
            //判断
            while(flag != 2){
                c2.await();
            }
            //做工
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //跳转
            flag =3;
            c3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
    }

    public void speak15(){
        lock.lock();
        try {
            //判断
            while(flag != 3){
                c3.await();
            }
            //做工
            for(int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //跳转
            flag =1;
            c1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
    }











}
