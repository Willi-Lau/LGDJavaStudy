package com.lwy.java;

import java.util.Arrays;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/4 10:09
 * 第二次手写ArrayList
  * @Param: null
 * @return
 */
public class MyArrayList2 {
    private int size;

    transient Object[] elementDate;

    private Object[] DEFAULT_ELEMENTDATA = {};

    private  int DEFAULT_SIZE = 10;
    /**
     * 构造函数 午餐
     */
    public MyArrayList2(){
        elementDate = DEFAULT_ELEMENTDATA;
    }
    /**
     * 构造函数 有参
     */
    public MyArrayList2(int index){
        if(index >0)
        {size = index;
        elementDate = new Object[index];}
        else if(index == 0){
            elementDate = DEFAULT_ELEMENTDATA;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * 扩容前判断
     */
    public void grow1(int num){
        if(elementDate == DEFAULT_ELEMENTDATA){
            num = Math.max(DEFAULT_SIZE,num);
        }
        //如果大了在扩容
        if(elementDate.length < num){
            grow(num);
        }
    }
    /**
     * 扩容
     */
    public void grow(int num){
        int oldsize = elementDate.length;
        int newsize = oldsize + (oldsize >> 1);
        if(newsize < num){
            newsize = num;
        }

        //替换
        elementDate = Arrays.copyOf(elementDate,newsize);
    }
    /**
     * 下标合法
     */
    public void badindex(int index){
        if(index >= size ){
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * add 不指定位置
     */
        public void add(Object o){
            //扩容
           grow1(size +1);
           //增加
            elementDate[size] = o;
            size += 1;
        }
    /**
     * add 指定位置
     */
    public void add(Object o ,int index){
        //下标是否合法 0 1 2 3 4
        badindex(index);
        //扩容
        grow1(size +1);
        //增加
        System.arraycopy(elementDate,index,elementDate,index+1,size -index);
        //加
        size += 1;
        elementDate[index] = o;
    }
    /**
     * 删除 根据index
     */
    public void remove(int index){
        //下标是否合法
        badindex(index);
        //删除
        System.arraycopy(elementDate,index+1,elementDate,index,size - index - 1);
        elementDate[size -1] = null;
        size -= 1;
    }
    /**
     * 根据元素删除
     */
    public void remove(Object object){
        if(object == null){
            for (int i=0;i<size;i++){
                if(elementDate[i] == null)
                    remove(i);
            }
        }
        else {
            for (int i=0;i<size;i++){
                if(elementDate[i] == object)
                    remove(i);
            }
        }

    }
    /**
     * 替换
     */
    public void set(int index,Object o){
        add(o,index);
        remove(index+1);

    }
    /**
     * 获取
     */
    public Object get(int index){
        badindex(index);
        return elementDate[index];
    }
    /**
     * 输出
     */
    public void print(){
        Arrays.asList(elementDate).forEach((i)->{
            if(i!= null){
                System.out.println(i);
            }
        });
    }
    /**
     * 长度
     */
    public int  size(){
       return size;
    }

    public static void main(String[] args) {
        MyArrayList2 list2 = new MyArrayList2();
        list2.add("hahah");
        System.out.println(list2.size);
        list2.add("hhhhhh");
        list2.remove(1);
        System.out.println(list2.size);
        list2.set(0,"lwy");
        list2.print();
    }
}
