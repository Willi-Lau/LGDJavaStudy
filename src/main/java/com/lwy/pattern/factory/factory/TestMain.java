package com.lwy.pattern.factory.factory;

import com.lwy.pattern.factory.factory.car.BlueCar;
import com.lwy.pattern.factory.factory.car.Car;
import com.lwy.pattern.factory.factory.car.RedCar;
import com.lwy.pattern.factory.factory.carfactory.AllCarFactory;
import com.lwy.pattern.factory.factory.carfactory.BlueCarFactory;
import com.lwy.pattern.factory.factory.carfactory.RedCarFactory;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/17 13:31
 * 普通工厂模式：
 *      创造的都是一类产品对象，创建的较多if else的简单工厂不能满足使用工厂模式，定义一个总工厂接口然后不同的分工厂去实现接口
  * @Param: null
 * @return
 */
public class TestMain {
    public static void main(String[] args) {
        //创造蓝色车
        AllCarFactory blueCarFactory = new BlueCarFactory();    //通过多态指定要使用哪个工厂
        BlueCar car = (BlueCar)blueCarFactory.makeCar();
        car.run();
        //创造红色车
        AllCarFactory redCarFactory = new RedCarFactory();       //通过多态指定要使用哪个工厂
        RedCar car2 = (RedCar)redCarFactory.makeCar();
        car2.run();

    }
}
