package com.lwy.pattern.factory.abstractfacory.factory.bookfactory;

import com.lwy.pattern.factory.abstractfacory.entity.book.Book;
import com.lwy.pattern.factory.abstractfacory.entity.book.SpringBook;
import com.lwy.pattern.factory.abstractfacory.entity.car.Car;

public class SpringBookFactory implements BookFactory{
    @Override
    public Book makeBook() {
        return new SpringBook();
    }

    @Override
    public Car makeCar() {
        return null;
    }
}
