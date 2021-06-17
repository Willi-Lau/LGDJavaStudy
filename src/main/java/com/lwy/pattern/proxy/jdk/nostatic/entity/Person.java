package com.lwy.pattern.proxy.jdk.nostatic.entity;

import com.lwy.pattern.proxy.jdk.nostatic.entity.Eat;
import com.lwy.pattern.proxy.jdk.nostatic.entity.Sleep;

/**
 * 被代理的类  通过接口找到这个类有哪些方法，根据这些方法创造出一个新的类 然后通过新的类去实现增强功能
 */
public class Person implements Eat, Sleep {
    @Override
    public void eat() {
        System.out.println("-------------吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("-------------睡觉");
    }

    /**
     * 这个方法jdk动态代理代理不到 因为没有接口有这个方法
     */
    public void dsp() {
        System.out.println("-------------董世苹是傻逼");
    }
}
