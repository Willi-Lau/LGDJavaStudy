package com.lwy.pattern.factory.factory.carfactory;

import com.lwy.pattern.factory.factory.car.Car;
import com.lwy.pattern.factory.factory.car.RedCar;

public class RedCarFactory implements AllCarFactory{

    @Override
    public Car makeCar() {
        return new RedCar();
    }
}
