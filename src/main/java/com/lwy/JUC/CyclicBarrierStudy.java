package com.lwy.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CyclicBarrierStudy {
    public static void main(String[] args) {
        //完成2个H一个O 输出一个水
        CyclicBarrier cyclicBarrierflag = new CyclicBarrier(3, ()->{
            System.out.println("make success H2O");
        });

        CyclicBarrierStudy cyclicBarrierstudy = new CyclicBarrierStudy();
         //线程部分
             for (int j=0;j<2;j++){
                 new Thread(()->{
                     for (int i=1;i<=4;i++){
                         try {
                             cyclicBarrierstudy.makeO();
                             cyclicBarrierflag.await();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         } catch (BrokenBarrierException e) {
                             e.printStackTrace();
                         }
                     }
                 }).start();
                 new Thread(()->{
                     for (int i=1;i<=8;i++) {
                         try {
                             cyclicBarrierstudy.makeH();
                             cyclicBarrierflag.await();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         } catch (BrokenBarrierException e) {
                             e.printStackTrace();
                         }
                     }
                 }).start();
             }
    }

    //两个H可以开启一个O  一个O可以开启两个H
    //？？刚开始只给两个H不会有bug 别的给法第一次输出偶尔会有小BUG
    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(0);
    //制作O
    public void makeO() throws InterruptedException, BrokenBarrierException {
        semaphoreO.acquire(2);
        System.out.println("O");
        semaphoreH.release(2);

    }
    //制作H
    public void makeH() throws InterruptedException, BrokenBarrierException {
        semaphoreH.acquire(1);
        System.out.println("H");
        semaphoreO.release(1);
    }

}
