package com.lwy.pattern.template;


/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/18 11:40
 * 模板模式：
 *  模板类为父类，定义好模板，及一些实现，某些关键性的实现留给子类去实现
  * @Param: null
 * @return
 */
public abstract class CookTemplate {
    /**
     * 做饭的具体模板
     */
    public void cook(){
        this.begin();
        this.addfood();
        this.end();
    }

    /**
     * 预留给子类具体的实现
     */
    public abstract void addfood();

    public void begin(){
        System.out.println("开始做饭！");
    }

    public void end(){
        System.out.println("结束做饭");
    }

}
