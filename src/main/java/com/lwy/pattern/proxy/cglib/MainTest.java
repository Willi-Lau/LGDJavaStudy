package com.lwy.pattern.proxy.cglib;

import com.lwy.pattern.proxy.cglib.entity.Person;
import com.lwy.pattern.proxy.cglib.proxyinf.ProxyCglib;

public class MainTest {
    public static void main(String[] args) {
        Person proxy = ProxyCglib.createProxy(new Person());
        proxy.speak();
    }
}
