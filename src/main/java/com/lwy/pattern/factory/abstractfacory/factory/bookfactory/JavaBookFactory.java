package com.lwy.pattern.factory.abstractfacory.factory.bookfactory;

import com.lwy.pattern.factory.abstractfacory.entity.book.Book;
import com.lwy.pattern.factory.abstractfacory.entity.book.JavaBook;
import com.lwy.pattern.factory.abstractfacory.entity.car.Car;

public class JavaBookFactory implements BookFactory{
    @Override
    public Book makeBook() {
        return new JavaBook();
    }

    @Override
    public Car makeCar() {
        return null;
    }
}
