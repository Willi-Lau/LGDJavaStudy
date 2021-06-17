package com.lwy.pattern.factory.abstractfacory.factory.carfactory;

import com.lwy.pattern.factory.abstractfacory.entity.book.Book;
import com.lwy.pattern.factory.abstractfacory.entity.car.BlueCar;
import com.lwy.pattern.factory.abstractfacory.entity.car.Car;
import com.lwy.pattern.factory.factory.carfactory.AllCarFactory;

public class BlueCarFactory implements CarFactory {

    @Override
    public Book makeBook() {
        return null;
    }

    @Override
    public Car makeCar() {
        return new BlueCar();
    }
}
