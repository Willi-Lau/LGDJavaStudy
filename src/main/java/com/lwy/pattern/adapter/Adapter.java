package com.lwy.pattern.adapter;


import com.lwy.pattern.adapter.adapter.toClass.AdapterToClass;
import com.lwy.pattern.adapter.adapter.toObject.AdapterToObject;
import com.lwy.pattern.adapter.watchtv.WatchTVDemo;

/**
 * 将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，适配器模式分为类结构型模式
 *  （继承）和对象结构型模式（组合）两种，前者（继承）类之间的耦合度比后者高，且要求程序员了解现有组件库中的相
 *  关组件的内部结构，所以应用相对较少些。
 *
 *  A接口 播放电影
 *  B接口 转换成英文
 */
public class Adapter {
    public static void main(String[] args) {
        //使用toclass 包下 继承的适配器
        AdapterToClass adapterToClass = new AdapterToClass(new WatchTVDemo());
        adapterToClass.watch();
        //使用toobject 对象适配器
        AdapterToObject object = new AdapterToObject(new WatchTVDemo());
        object.watch();

    }
}
