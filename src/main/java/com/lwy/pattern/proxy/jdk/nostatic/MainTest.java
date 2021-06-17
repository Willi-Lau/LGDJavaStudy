package com.lwy.pattern.proxy.jdk.nostatic;

import com.lwy.pattern.proxy.jdk.nostatic.entity.Eat;
import com.lwy.pattern.proxy.jdk.nostatic.entity.Person;
import com.lwy.pattern.proxy.jdk.nostatic.proxyinf.ProxyJDK;

/**
 * 动态代理模式：
 * JDK要求被代理对象必须有接口
 *
 * 代理对象和目标对象的相同点在于都是同一个接口
 */
public class MainTest {
    public static void main(String[] args) {
        //代理eat接口的方法
        Eat person = new Person();
        //生成person 的替代品 代理对象 通过相同接口获取到方法新建 代理
        Eat proxy_person = ProxyJDK.getProxy(person);
        //执行代理的 加强方法 这里只有 eat() 因为 Eat接口下只有这一个方法
        proxy_person.eat();

        //尝试代理没有接口实现的方法 dsp()   会报一个 java.lang.ClassCastException
        Person person1 = new Person();
        Person proxy = (Person)ProxyJDK.getProxy(person);
        proxy.dsp();

    }
}
