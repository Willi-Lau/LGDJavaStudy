package com.lwy.pattern.prototype;

import lombok.Data;

import java.util.HashMap;

@Data
public class Person implements Cloneable{
    private String name;
    private Integer age;

    HashMap map = new HashMap();

    public Person(){
        System.out.println("实例化person");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = new Person();
        p.setAge(age);
        p.setName(name);
        return p;
    }
}
