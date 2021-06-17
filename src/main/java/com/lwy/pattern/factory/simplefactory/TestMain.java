package com.lwy.pattern.factory.simplefactory;


import com.lwy.pattern.factory.simplefactory.car.Car;
import com.lwy.pattern.factory.simplefactory.carfactory.Simplefactory;

public class TestMain {
    public static void main(String[] args) {
        Simplefactory simplefactory = new Simplefactory();

        Car car = simplefactory.getCar("red");
        car.run();

        Car car2 = simplefactory.getCar("blue");
        car2.run();
        //不存在 123 会空指针
        Car car3 = simplefactory.getCar("123");
        car3.run();

    }
}
