package com.lwy.Leetcode.Thread;

import java.util.concurrent.Semaphore;

public class Thread20201227_TestSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Foo_1227 foo = new Foo_1227();
        foo.first(new Thread(()->{
            System.out.println("first");
        }));
        foo.second(new Thread(()->{
            System.out.println("second");
        }));
        foo.third(new Thread(()->{
            System.out.println("third");
        }));
    }

}

class Foo_1227{
    public Foo_1227(){

    }
   public Semaphore sema1 =  new Semaphore(0);
   public Semaphore sema2 = new Semaphore(0);


   public void first(Runnable firstThread){
       firstThread.run();
       sema1.release();
   }

    public void second(Runnable secondThread) throws InterruptedException {
        sema1.acquire();
        secondThread.run();
        sema2.release();
    }

    public void third(Runnable thirdThread) throws InterruptedException {
       sema2.acquire();
       thirdThread.run();

    }
}
