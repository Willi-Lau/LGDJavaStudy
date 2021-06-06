package com.lwy.java;

import lombok.val;
import org.apache.commons.pool2.BaseObjectPool;

import java.util.Objects;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/6 16:36
 * 
  * @Param: null
 * @return 
 */
public class MyHashMap {

    private final int INITCAPATTY = 10000;
    public Node[] array = new Node[INITCAPATTY];

    static class Node{
        private Object key,value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashCode(Object o){
        return o == null ? 0 : (o.hashCode())^(o.hashCode() >>> 16);
    }

    public int getIndex(Object o){
        int i = hashCode(o);
        return i % INITCAPATTY;
    }

    public Object get(Object key){
        //获取索引位置
        int index = getIndex(key);
        //找到数组中索引
        Node node = array[index];
        //然后找到
        if(node != null){
            if(node.key == key){
                return node.value;
            }
            else {
                //循环链表
                while (node.value != null){
                    if(node.key == key){
                        return node.value;
                    }
                    node = node.next;
                }
            }
        }

        return "没有找到";
    }

    public void put(Object key,Object value){
        //根据key计算索引
        int index = getIndex(key);
        //定义节点
        Node prev = null;
        Node now;
        now = array[index];
        //当前索引下节点不是空
        if(now != null){
            //查看是否需要替换
            while (now != null){
                if (now.key == key){
                    now.value = value;
                    return;
                }
                prev = now;
                now = now.next;
            }
            prev.next = new Node(key,value);
        }
        else {
            array[index] = new Node(key,value);
        }

    }

    public void remove(Object key){
        //找到节点的索引
        int index = getIndex(key);
        Node prev = null,now;
        now = array[index];
        //找到节点的位置
        while (now != null){
            if(now.key == key){
                //判断是不是首节点
                if(now == array[index]){
                    //是的话直接把索引指向第二个
                    array[index] = now.next;
                }
                //判断是不是尾节点
                else if(now.next == null){
                    prev.next = null;
                }
                else {
                    prev.next = now.next;
                }
            }
            prev = now;
            now = now.next;
        }


    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        System.out.println(map.get(2));
        map.remove(3);
        System.out.println(map.get(3));
    }
}
