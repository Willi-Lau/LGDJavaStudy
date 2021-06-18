package com.lwy.pattern.template;

public class MyCook extends CookTemplate{
    /**
     * 子类只需要实现末班没有具体实现的关键步骤即可
     */
    @Override
    public void addfood() {
        System.out.println("炒菜，加鸡蛋");
    }
}
