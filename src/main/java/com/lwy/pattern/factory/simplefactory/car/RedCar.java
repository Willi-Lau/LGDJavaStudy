package com.lwy.pattern.factory.simplefactory.car;

public class RedCar implements Car {
    public RedCar() {
        System.out.println("创建一个红色车");
    }

    @Override
    public void run() {
        System.out.println("红色车跑");
    }
}
