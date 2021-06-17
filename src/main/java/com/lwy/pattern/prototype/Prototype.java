package com.lwy.pattern.prototype;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/17 11:49
 *
 * 原型模式
 * 一个对象需要提供给其他对象访问，避免访问对象修改原来的值，就采用原型模式，克隆一份对象给访问者。
 *         实现 Cloneable接口，重写 clone方法，然后获取对象获取的就是克隆的，即使修改也不会影响到原来的值
  * @Param: null
 * @return
 */
public class Prototype {
    public static void main(String[] args) throws  Exception{
        LiuMyBatis liuMyBatis = new LiuMyBatis();
        Person p = liuMyBatis.getPerson("张三");
        System.out.println(p.getName());
        //无论怎么修改都不会影响数据库原本的值 适合只读模式下防止错误修改
        p.setName("18");
        Person p2 = liuMyBatis.getPerson("张三");
        System.out.println(p2.getName());
    }
}


