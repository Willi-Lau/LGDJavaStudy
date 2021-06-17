package com.lwy.pattern.factory.abstractfacory.factory;

import com.lwy.pattern.factory.abstractfacory.entity.book.Book;
import com.lwy.pattern.factory.abstractfacory.entity.car.Car;

/**
 * AllFactory -> CarFactory / BookFactory  -> 具体的哪一款式的工厂 比如 BlueCarFactory  -> 然后就是造出东西
 */
public interface AllFactory {
    /**
     * 新建book
     * @return
     */
    Book makeBook();
    /**
     * 新建 car
     */
    Car makeCar();
}
