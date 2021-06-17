package com.lwy.pattern.factory.abstractfacory.entity.book;

public class JavaBook implements Book{
    @Override
    public void read() {
        System.out.println("java good");
    }
}
