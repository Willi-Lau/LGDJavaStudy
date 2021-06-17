package com.lwy.pattern.decorator;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/17 18:41
 * 装饰器 通过装饰器类本身对待增强类进行增强 而不是适配器那样通过其他类增强
  * @Param: null
 * @return
 */
public class MyDecorator {
    private Car car;

    public MyDecorator(Car car) {
        this.car = car;
    }

    public void doDecorator(){
        System.out.println("增强小汽车空调");
        car.run();
        System.out.println("增强小汽车时速！！提高到120");
    }
}
