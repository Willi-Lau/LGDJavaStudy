package com.lwy.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchStudy {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i=1;i<=6;i++){
            int finalI = i;
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println(Integer.toString(finalI)+"同学出门");
                    countDownLatch.countDown();


            }).start();
        }
            //当CountDownLatch存在时就阻塞，到0消失了就不阻塞了
            countDownLatch.await(5, TimeUnit.SECONDS);    //这里是计时的用法 超过时间自动执行关门不再等待
            System.out.println("所有人都走了，关门");


    }
}
