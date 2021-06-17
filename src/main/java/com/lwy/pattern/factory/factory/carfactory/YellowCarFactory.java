package com.lwy.pattern.factory.factory.carfactory;

import com.lwy.pattern.factory.factory.car.Car;
import com.lwy.pattern.factory.factory.car.YellowCar;

public class YellowCarFactory implements AllCarFactory{

    @Override
    public Car makeCar() {
        return new YellowCar();
    }
}
