package com.lwy.pattern.factory.abstractfacory;

import com.lwy.pattern.factory.abstractfacory.entity.book.Book;
import com.lwy.pattern.factory.abstractfacory.entity.car.Car;
import com.lwy.pattern.factory.abstractfacory.factory.AllFactory;
import com.lwy.pattern.factory.abstractfacory.factory.bookfactory.JavaBookFactory;
import com.lwy.pattern.factory.abstractfacory.factory.carfactory.BlueCarFactory;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/17 14:03
 *
  * @Param: null
 * @return
 */
public class TestMain {
    public static void main(String[] args) {
        //工厂造车
        AllFactory factory = new BlueCarFactory();     //根据多态选择具体使用哪个工厂
        Car car = factory.makeCar();
        car.run();
        //工厂造书
        AllFactory factory2 = new JavaBookFactory();    //根据多态选择具体使用哪个工厂
        Book book = factory2.makeBook();
        book.read();

    }
}
