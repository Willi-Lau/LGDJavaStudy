package com.lwy.Leetcode.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread20210103_CyclicBarrier {

    public static void main(String[] args) {
      new TestCyclicBarrier().dothread();
    }
}

class TestCyclicBarrier{



     CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {

            System.out.println("达到要求");

            if(cyclicBarrier.isBroken()){
                /**
                 * 这里如果执行reset() 时，线程处于等待状态，就会触发BrokenBarrierException
                 */
                 cyclicBarrier.reset();
            }
            else {
                System.out.println("屏障破损");
            }
        }
    });

    public void dothread(){

        for(int i = 0;i < 5 ; i++){
               new Thread(()->{
                   try {
                       cyclicBarrier.await();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } catch (BrokenBarrierException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName());
               },"线程"+i).start();
        }
    };

}
