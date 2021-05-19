package com.lwy.study202105.java;

/**
 * 单例模式
 * @time 20210518 23：12
 */
public class Java02Singleton {

    public static void main(String[] args) {
        Demo demo = Demo.getInstance();
        Demo demo1 = Demo.getInstance();
        System.out.println(demo.equals(demo1));
    }
}

/**
 * 线程安全单例模式（懒汉）
 */
class Demo{
    private static volatile Demo demo = null;
    private Demo(){}
    public static Demo getInstance(){

        if(demo == null){
            synchronized(Demo.class){
                if(demo == null){
                    demo = new Demo();
                }
            }
        }
        return demo;
    }

}

/**
 * 线程安全饿汉式
 */
class Demo2{
    private static final Demo2 DEMO2 = new Demo2();
    private Demo2(){}
    public static Demo2 getInstance(){
        return DEMO2;
    }

}

/**
 * 懒汉式
 */
class Demo3{
    private static Demo3 demo3= null;
    private Demo3(){}
    public static Demo3 getInstance(){
        if(demo3 == null){
            demo3 = new Demo3();
        }
        return demo3;
    }
}

