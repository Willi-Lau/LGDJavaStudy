package com.lwy.study202105.java;

public class JavaVariable {
    static int s;     //类变量 全局变量 类公有
    int i;       //成员变量 每一个实例化的对象自己私有
    int j;       //成员变量 每一个实例化的对象自己私有
    {         //静态代码块   再实例化类是才会调用 再构造方法前被调用
        int i=1;
        i++;          //就近原则 执行第八行 i
        j++;          //执行成员变量
        s++;          //执行成员变量
    }
    public void test(int j){
        i++;    //执行成员变量
        j++;     //就近原则 执行传递进来的j
        s++;    //执行成员变量
    }

    public static void main(String[] args) {
        JavaVariable j1 =new JavaVariable();   //执行代码块 s=1   j=1   因为j是成员变量，只跟着自己实例化的对象走
        JavaVariable j2 =new JavaVariable();   //执行代码块 s=2   j=1    因为j是成员变量，只跟着自己实例化的对象走
        j1.test(10); //执行 test    s=3 i=1  因为i是成员变量，只跟着自己实例化的对象走
        j1.test(20); //执行 test    s=4 i=2  因为i是成员变量，只跟着自己实例化的对象走
        j2.test(10); //执行 test    s=5 i=1
        System.out.println("j1"+j1.i+" "+j1.j+" "+s);  // 2   1   5
        System.out.println("j2"+j2.i+" "+j2.j+" "+s);  // 1   1   5
    }
}
