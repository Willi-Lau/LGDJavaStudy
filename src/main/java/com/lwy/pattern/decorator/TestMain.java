package com.lwy.pattern.decorator;

public class TestMain {
    public static void main(String[] args) {
        MyDecorator myDecorator = new MyDecorator(new Car());   //增强器 和待增强类
        myDecorator.doDecorator();  //执行增强方法
    }
}
