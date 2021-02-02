package com.lwy.ldh;


interface A{
    void eat();
}
public class Na {

    public void eat2(A a) {
         a.eat();
    }

    public static void main(String[] args) {
        Na na = new Na();
        na.eat2(
                //匿名内部类
                ()->{
                    System.out.println("吃");
                }
        );
    }
}
