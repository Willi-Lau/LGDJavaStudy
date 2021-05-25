package Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.*;

public class Test {
    volatile static Integer i = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    CyclicBarrier cyclicBarrier = new CyclicBarrier(1);



    public void one() throws InterruptedException, BrokenBarrierException {
        lock.lock();
        while (i != 1){
            condition1.await();
        }
        System.out.println("one");
        i++;
        condition2.signal();
        cyclicBarrier.await();
        lock.unlock();
    }
    public void two()throws Exception {
        lock.lock();
        while (i != 2){
            condition2.await();
        }
        System.out.println("two");
        i++;
        condition3.signal();
        cyclicBarrier.await();
        lock.unlock();

    }
    public void three() throws Exception {
        lock.lock();
        while (i != 3){
            condition3.await();
        }
        i++;
        System.out.println("tthree");
        cyclicBarrier.await();
        lock.unlock();

    }



    public static void main(String[] args) throws InterruptedException {
            Test t = new Test();

//        new Thread(()->{
//            try {
//                t.three();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//                new Thread(()->{
//                    try {
//                        t.one();
//                    } catch (InterruptedException | BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                }).start();
//
//        new Thread(()->{
//            try {
//                t.two();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
            ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
            integerThreadLocal.set(123);
            integerThreadLocal.set(1123);
            integerThreadLocal.set(11123);
             System.out.println(integerThreadLocal.get());


    }


}


