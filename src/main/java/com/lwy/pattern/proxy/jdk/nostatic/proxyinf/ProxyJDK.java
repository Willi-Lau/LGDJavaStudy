package com.lwy.pattern.proxy.jdk.nostatic.proxyinf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 从这里完成jdk动态代理 这个是通用的
 */
public class ProxyJDK<T> implements InvocationHandler {
    //被代理的对象
    private T target;
    //接受被代理的对象
    public ProxyJDK(T target) {
        this.target = target;
    }
    //通过这个方法 传递代理对象 然后获取到代理对象的所有信息 进行代理 进行增强
    public static<T> T getProxy(T target){
        /**
         * ClassLoader loader, 当前被代理对象的类加载器
         * Class<?>[] interfaces, 当前被代理对象所实现的所有接口
         * InvocationHandler h,
         *  当前被代理对象执行目标方法的时候我们使用h可以定义拦截增强方法
         */
        Object o = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  //类加载器
                target.getClass().getInterfaces(),   //所在接口 没有就无法实现代理
                new ProxyJDK<T>(target)       //具体增强逻辑
        );

        return (T)o;
    }

    //定义目标方法的拦截逻辑；每个方法都会进来的 定义具体怎么增强
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //
        System.out.println("执行jdk 动态代理 方法增强");
        Object invoke = method.invoke(target, args);//方法.invoke(对象,参数数组)
        System.out.println("执行jdk 动态代理 增强完毕");
        return invoke;
    }
}
