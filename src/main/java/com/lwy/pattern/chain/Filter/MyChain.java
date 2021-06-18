package com.lwy.pattern.chain.Filter;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MyChain {
    //filter 链条
    static List<MyFilter> list = new ArrayList<>();
    //当前所在链条的位置
    static Integer flag = 0;


    //添加到链条
    public void addFilter(MyFilter filter){
        this.list.add(filter);
    }

    public void doFilter(MyRequest req,MyResponse resp,MyChain chain){
        //核心递归 调用当前 list里 filter 的下一个方法并且 flag ++
        if(flag < list.size()){
            list.get(flag++).doFilter(req,resp,chain);
        }
        else {
            //模拟原来要执行的方法
            System.out.println("哈哈哈哈哈哈哈哈哈哈");
        }

    }

}
