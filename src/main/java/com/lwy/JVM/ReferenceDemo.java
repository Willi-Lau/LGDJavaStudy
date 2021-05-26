package com.lwy.JVM;

import java.lang.ref.SoftReference;

/**
 * 四种引用  强引用 弱引用 虚引用  软引用
 * 强引用：Reference
 *         当内存不足时，JVM开始垃圾回收，对于强引用对象，就算是出现OOM也不会堆该对象进行回收，死都不收
 *
 *         强引用是我们最常见的普通对象引用，只要还有强引用指向一个对象，就能表明对象还活着，垃圾回收器不会碰这种对象。在Java中最常见的就是强引用
 *         ，把一个对象赋给一个引用变量，这个引用变量就是一个强引用。当一个对象被强引用变量引用时，它处于可达状态，他是不可能被垃圾回收机制回收的。
 *         即使该对象以后永远都不会被用到JVM也不会回收。因此强引用是造成Java内存泄露的主要原因
 *
 *         对于一个普通的对象，如果没有其他的引用关系，只要超过引用的作用或显式的将强引用赋值为null，一般就认为可以被垃圾收集的了
 *
 * 软引用 SoftReference：
 *         软引用是一种相对弱化的引用，需要使用java.lang.ref.SoftReference来实现，可以让对象豁免一些垃圾收集。
 *         对于只有软引用的对象来说
 *             当系统内存足够的时候 不会被回收
 *             当系统内部不足的时候 会被回收
 */
public class ReferenceDemo {   //  -XX:InitialHeapSize=5m -XX:MaxHeapSize=5m -XX:+PrintGCDetails
    public static void main(String[] args) {
        /**
         * 强引用部分 Reference
         */
            Object o1 = new Object(); //强引用
            Object o2 = o1;  //强引用
            o1 = null;  //强制给o1设置为null 解除强引用
            System.gc(); //执行垃圾回收
            System.out.println(o1);  //被回收
            System.out.println(o2);  //还存在
        /**
         * 软引用 SoftReference
         */
            Object o3 = new Object();
            SoftReference<Object> o4 = new SoftReference<>(o3);
            o3 = null;
            System.gc();  //垃圾回收，内存够用 o4不被回收 不够就被回收了
            try{
                Byte[] b =new Byte[100 * 1024 * 1024];   //现在设置的 最大heap大小为5m 实例化一个 100m的 btye数组 就会OOM 软引用就会被清理
            }catch (OutOfMemoryError e){
                e.printStackTrace();
            }
            finally {
                System.out.println(o3);
                System.out.println(o4.get());   //这里是获取软引用引用的对象
            }





    }
}
