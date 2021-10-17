package com.lwy.java;

public class T {
    public static int k = 0; //
    public static T t1 = new T("t1");   //这里比较特殊 执行到这里默认 static 加载过了 new
                                            // 是执行 <init> 方法 包含 代码块，普通变量初始化，构造方法执行
    public static T t2 = new T("t2");
    public static H t3 = new H();
    public static H t4 = new H();
    public static int i = print("i");  //3
    public static int n = 99; //

    static {
        print("静态块");
    }

    public int j = print("j");

    {
        print("构造块");
    }

    public T(String str) {
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n); // 1 0 0 - 2 1 1
        ++n; // 1 2
        ++i; //  1 2
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n); // 3  2 2
        ++n; // 3
        return ++i; // 3
    }

    public static void main(String[] args) {

    }
}


class H{
    static {
        System.out.println(123);
    }
    {
        System.out.println(456);
    }
}
