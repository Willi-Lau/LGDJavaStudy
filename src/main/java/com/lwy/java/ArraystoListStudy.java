package com.lwy.java;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList() 详解
 *
 * 开着奥迪卖小猪 2018-05-21 16:49:30  38129  收藏 162
 * 分类专栏： Java
 * 版权
 * 【1. 要点】
 *
 *  该方法是将数组转化成List集合的方法。
 *
 *  List<String> list = Arrays.asList("a","b","c");
 *
 * 注意：
 *
 * （1）该方法适用于对象型数据的数组（String、Integer...）
 *
 * （2）该方法不建议使用于基本数据类型的数组（byte,short,int,long,float,double,boolean）
 *
 * （3）该方法将数组与List列表链接起来：当更新其一个时，另一个自动更新
 *
 * （4）不支持add()、remove()、clear()等方法
 *
 *
 *
 *
 *
 * 【2.Arrays.asList()是个坑】
 *
 * 用此方法得到的List的长度是不可改变的，
 *
 * 当你向这个List添加或删除一个元素时（例如 list.add("d");）程序就会抛出异常（java.lang.UnsupportedOperationException）。 怎么会这样？只需要看看asList()方法是怎么实现的就行了：
 *
 * public static <T> List<T> asList(T... a) {return new ArrayList<>(a);}
 *
 * 当你看到这段代码时可能觉得没啥问题啊，不就是返回了一个ArrayList对象吗？问题就出在这里。
 *
 * 这个ArrayList不是java.util包下的，而是java.util.Arrays.ArrayList
 *
 * 它是Arrays类自己定义的一个静态内部类，这个内部类没有实现add()、remove()方法，而是直接使用它的父类AbstractList的相应方法。
 *
 * 而AbstractList中的add()和remove()是直接抛出java.lang.UnsupportedOperationException异常的！
 *
 * public void add(int index, E element) { throw new UnsupportedOperationException();}
 *
 * public E remove(int index) {throw new UnsupportedOperationException();}
 *
 *
 *
 * 总结：如果你的List只是用来遍历，就用Arrays.asList()。
 *
 *            如果你的List还要添加或删除元素，还是乖乖地new一个java.util.ArrayList，然后一个一个的添加元素。
 */
public class ArraystoListStudy {

    public static void main(String[] args) {
        List list = Arrays.asList(1,2,3,4);
        System.out.println("list长度 "+list.size());    //长度4

        //Arrays.asList 不建议使用基本类型
        int[] a = {1,2,3,4};
        List list2 = Arrays.asList(a);
        System.out.println("list2长度 "+list2.size()+"\n");    //长度1

        //原因
       // 在Arrays.asList种，接收参数时，八大基本类型不能作为集合泛型的参数，所以传递进来的是一个int[]类型的参数，这里只有一个int[] 所以长度就是1
//        int[] arr = {1,5,3,7,9};
//        List<int[]> ints2 = Arrays.asList(arr);

        list2.forEach(System.out::print);

        Integer[] b = {1,2,3,4};
        List list3 = Arrays.asList(b);
        System.out.println("\n"+"list3长度 "+list3.size());   //长度4
        list3.forEach(System.out::print);

        //接下来会报错   Arrays.asList 不能执行 add remove 否则会报错

        list.add(123);


    }
}
