package com.lwy.pattern.factory.abstractfacory.entity.book;

public class SpringBook implements Book{
    @Override
    public void read() {
        System.out.println("spring cloud !!!");
    }
}
