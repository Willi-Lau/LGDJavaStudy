package com.lwy.pattern.factory.abstractfacory.factory.bookfactory;

import com.lwy.pattern.factory.abstractfacory.entity.book.Book;
import com.lwy.pattern.factory.abstractfacory.entity.car.Car;
import com.lwy.pattern.factory.abstractfacory.factory.AllFactory;

public interface BookFactory extends AllFactory {
    @Override
    Book makeBook();

    @Override
    default Car makeCar(){
        return null;
    };
}
