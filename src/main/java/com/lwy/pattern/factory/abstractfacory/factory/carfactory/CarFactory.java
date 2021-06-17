package com.lwy.pattern.factory.abstractfacory.factory.carfactory;

import com.lwy.pattern.factory.abstractfacory.entity.book.Book;
import com.lwy.pattern.factory.abstractfacory.entity.car.Car;
import com.lwy.pattern.factory.abstractfacory.factory.AllFactory;

public interface CarFactory extends AllFactory {
    @Override
    Book makeBook();

    @Override
    default Car makeCar(){
        return null;
    }
}
