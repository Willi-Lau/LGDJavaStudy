package com.lwy.JUC;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchStudy2 {
    CountDownLatch countDownLatch1 = new CountDownLatch(0);
    CountDownLatch countDownLatch2 = new CountDownLatch(1);
    CountDownLatch countDownLatch3 = new CountDownLatch(1);
    public static void main(String[] args) throws Exception{
        CountDownLatchStudy2 study2 = new CountDownLatchStudy2();

        new Thread(()->{
            try {
                study2.onespeak();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                study2.threespeak();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                study2.twospeak();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



    }

    public void onespeak() throws InterruptedException {
           countDownLatch1.await();
            System.out.println("我是1");
            countDownLatch2.countDown();
        }



    public void twospeak() throws InterruptedException {

        countDownLatch2.await();
        System.out.println("我是2");
        countDownLatch3.countDown();

    }

    public void threespeak() throws InterruptedException {

        countDownLatch3.await();
            System.out.println("我是3");



    }


}
