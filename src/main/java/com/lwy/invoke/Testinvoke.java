package com.lwy.invoke;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Testinvoke {


    public static void main(String[] args) throws Exception {
        Pig pig = new Pig();
        //获取包的位置
        System.out.println(pig.getClass());
        //包的位置
        Class clazz =Class.forName("com.lwy.invoke.Pig");
        //要执行的方法和参数类型
        Method eat = clazz.getMethod("eat", Class.forName("java.lang.String"));
        //实例化对象 参数
        String invoke = (String) eat.invoke(pig, "卢本伟");
        System.out.println(invoke);
    }
}

class Pig{
    public String eat(String name){
        System.out.println(name+"正在吃");

        return name;
    }
}
