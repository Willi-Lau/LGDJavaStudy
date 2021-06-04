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

    static int a = 1;
    static int b = 2;
    public static void main(String[] args) throws InterruptedException {
        //static String c = "3";
//        String c = "3";
//        System.out.println(a+b+c);
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
//        Lock lock = new ReentrantLock(true);
//        Semaphore semaphore = new Semaphore(10);
//        List list = new ArrayList();
        String str1="abcde";
        String str2= str1.substring (4);
        String str3=new String (str2);
        String str4=new String (str2.toCharArray ());
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    }


}


