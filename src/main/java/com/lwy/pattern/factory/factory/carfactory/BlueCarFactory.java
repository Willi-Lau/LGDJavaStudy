package com.lwy.pattern.factory.factory.carfactory;

import com.lwy.pattern.factory.factory.car.BlueCar;
import com.lwy.pattern.factory.factory.car.Car;

public class BlueCarFactory implements AllCarFactory{

    @Override
    public Car makeCar() {
          return new BlueCar();
    }
}
