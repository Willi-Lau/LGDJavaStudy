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
//        String str1="abcde";
//        String str2= str1.substring (4);
//        String str3=new String (str2);
//        String str4=new String (str2.toCharArray ());
//        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
//        LinkedList linkedList = new LinkedList();
//        ArrayList list1 = new ArrayList(15);
//        int size = list1.size();
//        System.out.println(size);
//        list1.add(12);
//        System.out.println(list1.size());
//
//        Integer i = new Integer(100);
//        HashSet set = new LinkedHashSet();
//        set.add(11111);
//        set.add(22222);
//        set.add(33333);
//        set.add(44444);
//        set.forEach(System.out::println);
//
//
//        HashMap map = new HashMap(32);
//        map.put(1,1);
//        System.out.println(map.size());
//
//            ConcurrentMap map1 = new ConcurrentHashMap();
        double q = 1.2d;
        double p = 1.2d;
        System.out.println(q == p);

        String s = null;


        try{
            s = "刘伟艺";
            int i = 1/0;
        }
        catch(Exception m){
            m.printStackTrace();
        }
        finally {
            System.out.println(s);
        }

        int m = 0;
        //  int short long double float boolean char byte
        //   4    2      8     8    4     1       2     1

    }

        float fun(int a,int b){
            return 0;
        }


        float fun(int a,float b){
            return 0;
        }





}


