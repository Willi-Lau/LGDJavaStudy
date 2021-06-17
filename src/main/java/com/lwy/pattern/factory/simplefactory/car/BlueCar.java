package com.lwy.pattern.factory.simplefactory.car;

public class BlueCar implements Car {
    public BlueCar() {
        System.out.println("创建一个蓝色车");
    }

    @Override
    public void run() {
        System.out.println("蓝色车再跑");
    }
}
