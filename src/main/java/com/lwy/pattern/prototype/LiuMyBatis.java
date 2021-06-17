package com.lwy.pattern.prototype;


import java.util.HashMap;

/**
 * 实现 原型模式
 * 一个对象需要提供给其他对象访问，避免访问对象修改原来的值，就采用原型模式，克隆一份对象给访问者。
 *         实现 Cloneable接口，重写 clone方法，然后获取对象获取的就是克隆的，即使修改也不会影响到原来的值
 */
public class LiuMyBatis {
     //缓存user
    private HashMap<String,Person> map = new HashMap();
    //获取

    public Person getPerson(String name) throws CloneNotSupportedException {
        Person person = null;
        //缓存中没有
        if(!map.containsKey(name)){
            //从数据库获取 假获取
            Person p = new Person();
            p.setName(name);
            p.setAge(18);
            //存取缓存
            map.put(name,p);
            //克隆
            Person clone = (Person) p.clone();
            person = clone;
            System.out.println("数据库读取");
        }
        //缓存中有
        else {
            Person person1 = map.get(name);
            //克隆
            Person clone = (Person) person1.clone();
            person = clone;
            System.out.println("缓存获取");
        }


        return person;
    }
}
