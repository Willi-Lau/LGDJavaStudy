package com.lwy.study202105.java;


/**
 * 学习java参数传递规则
 *  基本类型传数值
 *  引用类型传地址
 *  String + 八种包装类 传地址但不改变值
 */
public class Javaparameter {
    public static void main(String[] args) {
         int i = 1;
         Integer m = 300;
         String s = "hello";
         int[] arr = { 1 , 2 , 3 , 4 , 5 };
         Student student = new Student();

         change(i,m,s,arr,student);

        System.out.println(i);
        System.out.println(m);
        System.out.println(s);
        System.out.println(arr[0]);
        System.out.println(student.i); 
    }

    public static void change(int i,Integer m,String s,int[] arr,Student student){
        i = i + 1;
        m = m + 1;
        s = s + "word";
        arr[0] = 999;
        student.i += 1;

    }
}
class Student{
     int i = 100;
}
