package com.lwy.Java8;

import java.io.FileInputStream;


/**
 * 笔记： 每一个类的静态代码块是jvm首次执行 ClassLoder后 产生 .class文件 javac进行编译首次加载静态信息。
 *      也就是说在首次new() 或者首次Class.forName() 或者首次main 即首次加载 时可u一加载静态代码块，其他的时候都不会加载静态代码块
 *
 *      静态代码块 > 代码块 >构造方法
 */

class Father{

    public Father() {
        System.out.println("father 无参构造");
    }

    static {
        System.out.println("father 静态代码块");
    }
    {
        System.out.println("father 代码块");
    }



}

public class JVMStaticCode {
    static{
        System.out.println("主类静态代码块");
    }
    {
        System.out.println("主类代码块");
    }
    public static void main(String[] args) {
        System.out.println("******************进入main");
        new Father();
        new JVMStaticCode();
        System.out.println("________________________");
        new Father();
        new JVMStaticCode();


    }


}
