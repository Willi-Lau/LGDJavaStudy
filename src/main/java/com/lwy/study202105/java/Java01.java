package com.lwy.study202105.java;


/**
 *  @time 20210518 22:45
 */
public class Java01 {
    public static void main(String[] args) {
        /**
         *  java 自增变量
         */
        int i = 1;
        i = i++;    //局部变量表    1  -》 2  (执行 i++)->  1  （从操作数栈取出）    操作数栈（FILO）  1 (从局部变量表取出来) -> 返回给局部变量表
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i: "+i);
        System.out.println("j: "+j);
        System.out.println("k: "+k);


    }

}
