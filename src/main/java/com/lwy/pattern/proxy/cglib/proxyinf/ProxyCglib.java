package com.lwy.pattern.proxy.cglib.proxyinf;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyCglib {

//    创建代理器
    public static<T> T createProxy(T t){
        //创建一个增强器
        Enhancer enhancer = new Enhancer();
        //设置要为哪个类进行增强 生成一个子类
        enhancer.setSuperclass(t.getClass());
        //设置回调 设置具体增强方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //增强
                System.out.println("执行cglib");
                //原来的方法
                Object o1 = methodProxy.invokeSuper(o, objects);
                return o1;
            }
        });

        Object o = enhancer.create();
        return (T)o;


    }
}
