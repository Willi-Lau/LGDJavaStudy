package com.lwy.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 总次数正确 第一次输出时还是会有小bug 剩下的就好了 第一次输出 偶尔HHOH 或 HHOHH才会显示制作一个H20
 */
public class CyclicBarrierStudy {
    public static void main(String[] args) throws InterruptedException {
        //完成2个H一个O 输出一个水


        Water water = new Water();
        CountDownLatch countDownLatch = new CountDownLatch(300);
        //线程部分
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {

                try {
                    water.makeO();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        for (int j = 0; j < 200; j++) {
            new Thread(() -> {

                try {
                    water.makeH();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        //统计次数
         countDownLatch.await();
         System.out.println(water.tim);
    }


}

class Water{
    int tim = 0;
    //两个H可以开启一个O  一个O可以开启两个H
    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(0);
    CyclicBarrier cyclicBarrierflag = new CyclicBarrier(3, ()->{
        System.out.println("make success H2O");
        tim ++;
    });
    //制作O
    public void makeO() throws InterruptedException, BrokenBarrierException {
        semaphoreO.acquire(2);
        System.out.println("O");
        semaphoreH.release(2);
        cyclicBarrierflag.await();

    }
    //制作H
    public void makeH() throws InterruptedException, BrokenBarrierException {
        semaphoreH.acquire(1);
        System.out.println("H");
        semaphoreO.release(1);
        cyclicBarrierflag.await();
    }

}
