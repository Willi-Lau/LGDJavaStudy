package com.lwy.Java8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//函数式接口
@FunctionalInterface
interface Foo{
    void speak();

    static void dosb(){
        System.out.println("java 8 新特性 接口可以实现静态方法");
    }
}


//有返回值的接口
interface Fooo{
    int add(int a,int b);
    static void dosb(){
        System.out.println("java 8 新特性 接口可以实现静态方法");
    }

}


//java 8新特性 default 接口i
interface Foooo{
    //普通方法
    void myeat(int a,int b);
    //default 是默认方法
    default int eat(int a,int b){
        System.out.println("come in foooo eat default 部分");
        return a+b;
    }
}



public class LambdaStudy {


    //Lambda 口诀 拷贝小括号，写死右箭头，落地大括号

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        //普通线程实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread.currentThread().getName() 获取线程名字
                    System.out.println(Thread.currentThread().getName()+"启动");

            }
        },"线程1").start();

        //lambda 实现线程
        // () 写入参数
        // {} 写入实现
        new Thread(()->{ System.out.println(Thread.currentThread().getName()+"启动");},"线程2").start();
        Foo foo = new Foo() {  //普通实现
            @Override
            public void speak() {
                System.out.println("sb");
            }
        };

        Foo foo2 = () ->{              //lambda
            System.out.println("sb");
        };

        Fooo fooo = (int a, int b)->{    //有返回值的接口
            System.out.println("come in fooo add");
            return a + b;
        };


        System.out.println(fooo.add(5,10)); //调用有返回值的接口
        Fooo.dosb(); //java 8 新特性 接口可以实现静态方法  不过只能 接口名.方法名调用 不可以实例化调用
        Foooo foooo = (x,y)->{    //实现接口里唯一的普通方法
            System.out.println(x+y);
        };

        int eat = foooo.eat(15, 100);    //接口的默认方法
        System.out.println(eat);


    }
}


