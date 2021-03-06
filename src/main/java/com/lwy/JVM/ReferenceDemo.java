package com.lwy.JVM;

import sun.awt.windows.WPrinterJob;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

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
 *  弱引用 WeakReference
 *         不管内存是否足够都执行GC 使用java.lang.ref.WeakReference执行
 *   虚引用 PhantomReference
 *         顾名思义，就是形同虚设，与其他几种引用都不同，虚引用并不会决定对象的生命周期。
 *         如果一个对象仅持有虚引用的话，那么就和没有任何引用一样，在任何时候都可能被垃圾回收，他不能单独使用也不能通过访问对象，虚引用必须和引用队列
 *         ReferenceQueue 联合使用。
 *
 *         虚引用的主要作用是跟踪对象被垃圾回收的状态。仅仅是提供了一种确保对象被finalize以后，做某些事情的机制。
 *         PhantomReference的get方法总是返回null,因此无法访问对应的引用对象。其意义在于说明一个对象已经进入finalization阶段。可以被gc回收，用来
 *         实现比finalization机制更灵活的回收操作
 *
 *         换句话说，设置虚引用关联的唯一目的，就是在这和对象被收集器回收的时候收到一个系统通知或者后续添加进一步处理。
 *         Java技术允许使用finalize() 方法在垃圾收集器将对象从内存中清之前做必要的清理工作
 *
 *         说白了要死还没死 虚引用在引用队列呆一会再死
 */
public class ReferenceDemo {   //  -XX:InitialHeapSize=5m -XX:MaxHeapSize=5m -XX:+PrintGCDetails
    public static void main(String[] args) {
        /**
         * 强引用部分 Strong Reference
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
//                Byte[] b =new Byte[100 * 1024 * 1024];   //现在设置的 最大heap大小为5m 实例化一个 100m的 btye数组 就会OOM 软引用就会被清理
            }catch (OutOfMemoryError e){
                e.printStackTrace();
            }
            finally {
                System.out.println(o3);
                System.out.println(o4.get());   //这里是获取软引用引用的对象 只有OOM才会执行清楚
            }
        /**
         * 弱引用 WeakReference
         */
            Object o5 = new Object();
            WeakReference <Object> o6 = new WeakReference<>(o5);
            o5 = null;
            System.gc();
            System.out.println(o5);
            System.out.println(o6.get());   //这里是获取弱引用引用的对象  无论内存满不满都会被清除
        /**
         *  WeakHashMap
         */
            WeakHashMap<Integer,Integer> weakHashMap = new WeakHashMap();

            weakHashMap.put(new Integer(5),new Integer(8));
            System.out.println(weakHashMap);
            System.gc();   //执行GC后 weakhashmap里引用类型的所有东西都会被清理
            System.out.println( "***********"+weakHashMap);
          /**
             *   引用队列 ReferenceQueue
             * */
                Object o7 = new Object();
                ReferenceQueue<Object> queue = new ReferenceQueue<>();
                WeakReference <Object> weakReference = new WeakReference<Object>(o7,queue);  //传入对象和 queue
            //gc前查看
            System.out.println("***************************");
            System.out.println(o7);
            System.out.println(weakReference.get());
            System.out.println(queue.poll());

            //gc后查看
            o7 = null;
            System.gc();
            System.out.println(o7);
            System.out.println(weakReference.get());
            System.out.println(queue.poll());
            /**
             * 虚引用 PhantomReference
             */
            Object object_PhantomReference = new Object();
            ReferenceQueue<Object> queue1 = new ReferenceQueue<>();
            PhantomReference<Object> objectPhantomReference = new PhantomReference<>(object_PhantomReference,queue1);
            //gc前查看
            System.out.println("***************************");
            System.out.println(object_PhantomReference);
            System.out.println(objectPhantomReference.get());
            System.out.println(queue1.poll());

            //gc后查看
            object_PhantomReference = null;
            System.gc();
            System.out.println(object_PhantomReference);
            System.out.println(objectPhantomReference.get());
            System.out.println(queue1.poll());











    }
}
