package com.lwy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ArrayListThreadStudy {
    /**
     * new ArrayList 底层是new 一个类型为Object 长度为10的数组
     *
     * java 8 中 ，ArrayList 每次扩容为当前空间的一半（取整），比如要存进去长度为25的值，第一次为10，
     * 扩容到15，发现不够再次扩容到22,然后再次扩容到33。每次扩容底层采用Arrays.copyOf() 方法传递参数。
     *
     *     10 -> 15 -> 22 -> 33 ->.... 每次增加原值的一半再取整
     *
     * 扩容不是把原来容量为10的数组容量增加到15，因为数组的容量不可以变，定义多少就是多少，增加容量就是定义一个新数组，
     * 长度为15。使用Arrays.copyOf(老数组，新数组长度)，就可以返回一个新的数组，通过这种方式扩容，存放更多的数据
     * @param args
     */

    public static void main(String[] args) {
        HashMapThread();
//        HashSetThread();
//        ArrayListThread();
    }
    private static void HashMapThread(){
        //HashMap 线程不安全的例子

        HashMap hashMap = new HashMap();

        //线程安全
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                concurrentHashMap.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName()+concurrentHashMap);
            },"线程："+Integer.toString(i)).start();
        }


    }
    private static void HashSetThread(){
        //HashSet 线程不安全的例子
        //HashSet 底层是一个 HashMap
        HashSet<String> hashSet = new HashSet<>();
        //改正措施
        CopyOnWriteArraySet<Object> arraySet = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                arraySet.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName()+arraySet);
            },"线程："+Integer.toString(i)).start();
        }


    }

    private static void ArrayListThread() {
        //ArayList 多线程不安全的例子
        //此程序是一共10个线程，每一个线程添加一个随机码，所以list里应该有不为null的随机码（里面的值有几个不一定看线程抢东西的能力）,并且不报错
        //不安全
        List<String> list = new ArrayList();
        //解决办法1
        List <String> list1 = Collections.synchronizedList(new ArrayList<>());
        //解决办法2
        List <String> vector = new Vector<>();
        //解决办法3
        //新的线程安全实现类 JUC下
        List<String> list2 = new CopyOnWriteArrayList<>();
        //开启十个线程
        for (int i = 1; i <=10 ; i++) {
            new Thread(()->{
                //每一个线程往list 里添加一个随机代码
                list2.add(UUID.randomUUID().toString().substring(0,8));
                //输出线程名字和随即代码
                System.out.println(Thread.currentThread().getName()+": "+list2);
            },"线程"+Integer.toString(i)).start();
        }
    }
}
