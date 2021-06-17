package com.lwy.pattern.builder;
/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/17 16:25
 * 建造者模式 使用lombok自带的builder注解
  * @Param: null
 * @return
 */
public class Builder {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder().age(11).name("张三").phone("18240341244").build();
    }
}
