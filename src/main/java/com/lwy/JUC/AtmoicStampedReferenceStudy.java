package com.lwy.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtmoicStampedReferenceStudy {
    public static void main(String[] args) {
        //atomic  初始值100
        AtomicReference<Integer> integerAtomicReference =  new AtomicReference<>(100);
        /**
         * ABA 问题
         */
        new Thread(()->{
            //模拟出ABA问题 先变成101 再改回100
            integerAtomicReference.compareAndSet(100,101);
            integerAtomicReference.compareAndSet(101,100);
        },"ABA 线程1").start();

        new Thread(()->{
            //看看是否能发现ABA 如果更改就是没发现 需要引入版本问题
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            integerAtomicReference.compareAndSet(100,99999);
            //获取值
            System.out.println("ABA问题"+integerAtomicReference.get());
        },"ABA 线程2").start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * ABA的解决
         */
        /**
         * AtomicStampedReference 参数 ： 初始值，版本号
         */

        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<>(100,1);
        new Thread(()->{
            //模拟出ABA问题 先变成101 再改回100    这里加入版本号      参数：原始值 变更值 原始版本号 变更后的版本号
            integerAtomicStampedReference.compareAndSet(100,101,1,2);
            integerAtomicStampedReference.compareAndSet(101,100,2,3);
        },"ABA解决 线程1").start();

        new Thread(()->{
            //看看是否能发现ABA 如果更改就是没发现 需要引入版本问题
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = integerAtomicStampedReference.compareAndSet(100,99999,1,4);

            System.out.println(result+"最新版本号"+integerAtomicStampedReference.getStamp());
            //获取值
            System.out.println("ABA解决"+integerAtomicStampedReference.getReference());
        },"ABA解决 线程2").start();

    }
}
