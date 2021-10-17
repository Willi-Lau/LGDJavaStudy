package com.lwy.JVM;

import java.util.Random;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/7/4 18:12
 *
 *
 * 类加载 初始化相关学习
  * @Param: null
 * @return
 */
public class ClassLoaderDemo {

    public static int a = 1;     //初始化阶段赋值

    public static final int b = 2;     //链接 - 准备阶段赋值 （static final 修饰下 值是固定常量不是 对象或者通过方法获得的）

    public static final Integer c = Integer.valueOf(3);   //初始化阶段赋值 值是由一些其他对象方法加载的，不在链接 - 准备赋值

    public static final String d = new String("sb");   //初始化阶段赋值  值是由一些其他对象方法加载的，不在链接 - 准备赋值

    public static final Double e = new Random().nextDouble();   //初始化阶段赋值  值是由一些其他对象方法加载的，不在链接 - 准备赋值
}
