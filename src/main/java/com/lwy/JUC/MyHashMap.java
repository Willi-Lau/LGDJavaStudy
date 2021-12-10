package com.lwy.JUC;

import lombok.Data;

/**
 * my hashmap
 */
public class MyHashMap<K,V> {
    static Integer size = 16;
    static double flag = 0.75;
    static MyNode[] arr = null;

    @Data
    static
    class MyNode<K,V>{
        Object val;
        Object key;
        MyNode next;
        public MyNode(Integer key,Integer val,MyNode next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
        public MyNode(Integer key,Integer val){
            this.key = key;
            this.val = val;
        }
        public MyNode(Integer val){
            this.val = val;
        }
    }

    //初始化
    public MyHashMap(int s){
        Integer size = findSize(s);
    }

    public void put(Integer k,Integer v){
        //懒加载
        if(arr == null){
            arr = new MyNode[size];
        }
        //位置
        int i = k.hashCode() % size;
        if(arr[i] == null){
            arr[i] = new MyNode(k,v);
        }
        else {   //发生冲突
            MyNode node = arr[i];
            boolean f = false;
            while(node.next != null){
                if(node.getVal().equals(k)){
                    node.setVal(v);   //替换
                    f = true;
                    break;
                }
                node = node.next;
            }
            if(!f){ // 没有发生替换 尾部追加
                node.next = new MyNode(k,v);
            }
        }
    }


    //找到比传入size大的2的整数次方大小的数
    public Integer findSize(int size){
        int i = 2;
        while (true){
            if(i<size){
                i *= 2;
            }
            else {
                break;
            }
        }

        return i;
    }


}
