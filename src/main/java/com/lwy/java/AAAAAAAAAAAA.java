package com.lwy.java;


import java.util.Random;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/7/4 16:00
 *  面试题汇总
  * @Param: null
 * @return
 */
public class AAAAAAAAAAAA {

    public static int a = 1;     //初始化阶段赋值

    public static final int b = 2;     //链接 - 准备阶段赋值 （static final 修饰下 值是固定常量不是 对象或者通过方法获得的）

    public static final Integer c = Integer.valueOf(3);   //初始化阶段赋值 值是由一些其他对象方法加载的，不在链接 - 准备赋值

    public static final String d = new String("sb");   //初始化阶段赋值  值是由一些其他对象方法加载的，不在链接 - 准备赋值

    public static final Double e = new Random().nextDouble();   //初始化阶段赋值  值是由一些其他对象方法加载的，不在链接 - 准备赋值

    public static void main(String[] args) {
        /**
         * create by: liuweiyi
         * description: TODO
         * create time: 2021/7/4 11:05
         *  String类型 Intern()方法的学习
         *              String intern() {
         *      if(常量池找到该字面量的字符串) ｛
         *          return 常量池该字面量的字符串
         *     ｝
         *     if（常量池已经记录字符串字面量相等的引用） ｛
         *         return A
         *    ｝
         *     记录 堆上第一个与该字符串字面量相等的引用
         *     return 记录的引用
         *              }
         * @Param: null
         * @return
         */
        // 当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定）
        // ，则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此 String 对象的引用。
        // 说白了就是保证String s 指向的是字符串常量池中的数据 节约内存


        //没有接收返回值就是在常量池创建独对象
        //有接收返回值是指向第一次的引用



        //单独执行intern : 无论怎么比较 intern() 前面常量池里有这个字符串就是 false 没有就是true
        String i1 = new String("hello") + new String("word");   //这种不会添加到字符串常量池
        String i2 = "helloword";
        i1.intern(); //常量池中有了 相当于啥也没做
        System.out.println(i1 == i2);       //false   i1 指向堆  i2 指向 常量池

        String i3 = new String("s")+new String("b");   //这种不会添加到字符串常量池
        i3.intern();    //这一步添加到常量池  让 i3指向到常量池中
        String i4 = "sb";    //常量池中有了 指向和 i3一样了
        System.out.println(i3 == i4);     //true i3 i4 都指向常量池中

        String m1 = new String("m");
        m1.intern();    //常量池中有了 相当于啥也没做
        String m2 = "m";
        System.out.println(m1 == m2);   //false



        //再输出比较Intern 除了之前有的比如 java 剩下的都是true
        String i5 = new String("liu")+new String("weiyi");    //这种不会添加到字符串常量池
        String i6 = "liuweiyi";
        System.out.println(i5.intern() == i6);    //true  常量池里有 返回的就是 i6 所以相等
        System.out.println(i5.intern() == i5);   //false 常量池里有了 返回的是i6 不是 i5自己


        //
        int k = 10;
        k = k + k++ + ++k;  // 10   10   12
        System.out.println(k);    //输出 32  k++ 后面有人接 还会加上

        //
        Integer k1 = 1;
        int k2  =1;
        System.out.println(k1 == k2);    //true  Integer 和 int 比较会自动拆箱 Integer.intValue方法

        //
        Integer j =  new Integer(15);
        Integer j1 = 15;
        System.out.println(j == j1);    //false   一个在堆 一个在方法区

        //
        Integer j2 = 888;
        int j22 = 888;
        System.out.println(j2 == j22);    //true    Integer 和 int 比较会自动拆箱 Integer.intValue方法

        Integer a = 100;
        add(100);
                    //   static Integer add(Integer a){
                    //        return a + 100;
                    //    }
        System.out.println(a);   //100  8中基本类型及封装类 和 String  可以看做传的是值




    }
    static Integer add(Integer a){
        return a + 100;
    }
}
