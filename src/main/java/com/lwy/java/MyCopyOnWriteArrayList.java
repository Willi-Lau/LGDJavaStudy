package com.lwy.java;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/4 16:43
 *
  * @Param: null
 * @return
 * 第一次手写CopyOnWriteArrayList
 */
public class MyCopyOnWriteArrayList {

    final transient ReentrantLock lock = new ReentrantLock();

    private transient Object[] array;

    public void setArray(Object[] arr){
        this.array = arr;
    }

    public Object[] getArray(){
        return this.array;
    }

    /**
     * 无参构造
     */
    public MyCopyOnWriteArrayList(){
        array = new Object[0];
    }
    /**
     * add index
     */
    public boolean add(Object e){
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            //首先获取数组
            Object[] oldArray = getArray();
            Object[] newArray = Arrays.copyOf(oldArray,oldArray.length+1);
            newArray[oldArray.length] = e;
            setArray(newArray);
            return true;
        }
        finally {
            lock.unlock();
        }
    }
    /**
     * add index,object
     */
    public boolean add(Object e,int index){
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] oldArray = getArray();
            if(index <0 || index > array.length){
                throw new IndexOutOfBoundsException();
            }
            //0 1 2 3 4
            Object[] newArray = new Object[oldArray.length + 1];
            if(index == oldArray.length -1){
                System.arraycopy(oldArray,0,newArray,0,index);
                System.arraycopy(oldArray,index,newArray,index+1,oldArray.length - index);
            }
            else {
                newArray = Arrays.copyOf(oldArray,oldArray.length+1);
            }
            newArray[index] = e;
            setArray(newArray);
            return true;
        }
        finally {
            lock.unlock();
        }
    }
    /**
     * remove index
     */
    public boolean remove(int index){
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] oldArray = getArray();
            int oldlength = oldArray.length;
            Object[] newArray = new Object[oldlength - 1];
            if(index <0 || index>oldlength) throw new IndexOutOfBoundsException();
            if(index == oldlength){
                newArray = Arrays.copyOf(oldArray,oldlength - 1);
            }
            else {
                System.arraycopy(oldArray,0,newArray,0,index);
                System.arraycopy(oldArray,index+1,newArray,index,oldlength - index - 1);
            }
            setArray(newArray);
            return true;
        }
        finally {
            lock.unlock();
        }
    }
    /**
     * remove object
     */
    public boolean remove(Object e){
        Object[] array = getArray();
        int indexOf = indexOf(e, array, 0, size());
        return indexOf >=0 ? remove(e,indexOf,array):false;
    }
    public boolean remove(Object e,int index,Object[] oldArray){
      final ReentrantLock lock = this.lock;
      lock.lock();
      try {
          Object[] newArray = getArray();
          if(newArray != oldArray) over:{
              int oldlength = oldArray.length;
              int newlength = newArray.length;
              int minlength = Math.min(oldlength,newlength);
              if (newArray[index] == e){
                  break over;
              }
              for (int i=0;i<minlength;i++){
                  if(newArray[i] != oldArray[i] && newArray[i] == e)
                  {
                      index = i;
                      break over;
                  }
              }
              if(indexOf(e,newArray,0,newlength) == -1 || index < 0){
                  return false;
              }
          }
          Object[] upNewArray = new Object[oldArray.length - 1];
          System.arraycopy(newArray,0,upNewArray,0,index);
          System.arraycopy(newArray,index+1,upNewArray,index,newArray.length - index - 1);
          setArray(upNewArray);
          return true;
      }
      finally {
          lock.unlock();
      }

    }
    /**
     * set index,object
     */
    public boolean set(int index,Object e){
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] oldArray = getArray();
            int oldlenth = oldArray.length;
            Object[] newArray;
            if(index <0 || index>oldlenth) throw new IndexOutOfBoundsException();
            Object oldGetValue = get(index);
            if(oldGetValue == e ){
                return false;
            }
            else {
                newArray = Arrays.copyOf(oldArray,oldlenth);
                newArray[index] = e;
                setArray(newArray);
                return true;
            }
        } finally {
            lock.unlock();
        }

    }
    /**
     * get index
     */
    public Object get(int index){
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return array[index];
    }
    /**
     * size
     */
    public int size(){
        return array.length;
    }
    /**
     * indexOf
     */
     public int indexOf(Object e,Object[] arr,int begin,int end){
         if(e == null){
             for (int i=begin;i<end;i++){
                 if(arr[i] == null){
                     return i;
                 }
             }
         }
         else {
             for (int i=begin;i<end;i++){
                 if(arr[i].equals(e)){
                     return i;
                 }
             }
         }
         return -1;
     }

    public static void main(String[] args) {
        MyCopyOnWriteArrayList list = new MyCopyOnWriteArrayList();
        list.add(123);
        list.set(0,456);
        list.remove(0);
        list.add(789);
        System.out.println(list.get(0));

    }

}
