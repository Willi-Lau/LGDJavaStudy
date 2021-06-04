package com.lwy.java;

import java.util.Arrays;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/3 10:03
 *
 * 手写 ArrayList 次数1
  * @Param: null
 *  @return
 */
public class MyArrayList {

    private int size;

    transient Object[] elementData;

    private static Object[] DEFAULT_ELEMENTDATA = {};

    private static int DEFAULT_SIZE = 10;
    /**
     * 构造方法 无参
     */
    MyArrayList(){
        this.elementData = DEFAULT_ELEMENTDATA;  //等第一次执行add() 在指定数组长度
    }
    /**
     * 构造方法 有参
     */
    MyArrayList(int size){
        if(size >0){
            elementData = new Object[size];
            this.size = size;
        }
        else if(size == 0){
            this.elementData = DEFAULT_ELEMENTDATA;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * 增加 不指定位置
     */
    public void add(Object o){
        grow1(size + 1);
        elementData[size] = o;
        size ++;
    }
    /**
     * 指定位置增加
     */
    public void add(int index,Object o){
        badindex(index);  //判断下标是否合法
        grow1(size+1);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = o;
        size ++;
    }
    /**
     * 判断是否是初始化 初始化就赋值 10
     */
    public void grow1(int num){
        if(elementData == DEFAULT_ELEMENTDATA){
             num = Math.max(num,DEFAULT_SIZE);
        }
        if(num > elementData.length)    //必须加这句话 等空间不够在扩容
        {grow(num);}
    }
    /**
     * 删除 根据下标删除
     */
    public void remove(int index){
        //判断下标是否合法 0 1 2 3 4 5
        badindex(index);
        //删除 通过复制数组
        System.arraycopy(elementData,index + 1,elementData ,index,size-1-index);
        //删除空
        elementData[size-1] = null;
        size --;
    }
    /**
     * 删除 根据object 删除
     */
    public void remove(Object o){
        //找到 o 的下标
        if(o == null){
            for (int i=0;i<size;i++){
                if (elementData[i] == null){
                    remove(i);
                }
            }
        }
        else {
            for (int i=0;i<size;i++){
                if (elementData[i] == o){
                    remove(i);
                }
            }
        }
    }
    /**
     * 获取
     */
    public Object get(int index){
        badindex(index);
        return elementData[index];
    }
    /**
     * 更新
     */
    public void update(Object o,int index){
        remove(index);
        add(index,o);
    }
    /**
     * 扩容方法
     */
    public void grow(int minsize){
        int oldsize = elementData.length;
        int newsize = oldsize + (oldsize >> 1);
        if(newsize < minsize ){
            newsize = minsize;    //头一次add
        }
        elementData = Arrays.copyOf(elementData,newsize);   //这里的有对象来接

    }
    /**
     * 数组下标越界
     */
    public void badindex(int index){
        if(index >= elementData.length){
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * 输出
     */
    public void print(){
        for (int i=0;i<elementData.length;i++){
            if(elementData[i]!= null)
            System.out.println(elementData[i]);
        }
    }
    /**
     * 大小
     */
    public int size(){
        return size;
    }

}

class TestMyArrayList{
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i=0;i<15;i++){
            list.add(i);
        }

        list.update(567,0);
        list.remove(1);
        list.print();
        System.out.println("size = "+ list.size());

        MyArrayList list2 = new MyArrayList(100);
        System.out.println("size = "+list2.size());
        list2.add(456);
        list2.print();
    }
}
