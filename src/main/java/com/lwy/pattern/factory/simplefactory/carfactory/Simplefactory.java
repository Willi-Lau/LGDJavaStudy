package com.lwy.pattern.factory.simplefactory.carfactory;


import com.lwy.pattern.factory.simplefactory.car.BlueCar;
import com.lwy.pattern.factory.simplefactory.car.Car;
import com.lwy.pattern.factory.simplefactory.car.RedCar;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/17 12:50
 * 简单工厂：创建的都是同一种类的物品，种类还比较少，可以通过if else 来判断然后生成
  * @Param: null
 * @return
 */
public class Simplefactory {
    public Car getCar(String car){
        if(car.equals("red")){
            return new RedCar();
        }
        else if(car.equals("blue")){
            return new BlueCar();
        }
        else {
            return null;
        }
    }
}
