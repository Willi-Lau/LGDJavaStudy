package com.lwy.java;

import java.util.ArrayList;
/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/6 16:39
 * 
  * @Param: null
 * @return 
 */
public class ArrayListSizeBug {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(100);  //数组大小100 List大小为0
        int size = list.size();
        System.out.println(size);   //输出0
        list.set(1,1);    //IndexOutOfBoundsException 这里100是初始化数组的大小 list大小还是0 list 大小看size
    }
}
