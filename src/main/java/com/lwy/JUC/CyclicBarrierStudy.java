package com.lwy.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CyclicBarrierStudy {
    public static void main(String[] args) {
        //完成2个H一个O 输出一个水


        Water water = new Water();
        //线程部分
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {

                try {
                    water.makeO();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {

                }

            }).start();
        }
        for (int j = 0; j < 200; j++) {
            new Thread(() -> {

                try {
                    water.makeH();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }


}

class Water{
    //两个H可以开启一个O  一个O可以开启两个H
    Semaphore semaphoreH = new Semaphore(0);
    Semaphore semaphoreO = new Semaphore(2);
    CyclicBarrier cyclicBarrierflag = new CyclicBarrier(3, ()->{
        System.out.println("make success H2O");
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
