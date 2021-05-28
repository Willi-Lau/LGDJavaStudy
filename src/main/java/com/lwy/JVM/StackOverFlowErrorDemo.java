package com.lwy.JVM;

/**
 * 栈溢出异常
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        StackOverflowError();   //模拟出 StackOverFlowError
    }

    public static void StackOverflowError() {
        StackOverflowError();
    }
}
