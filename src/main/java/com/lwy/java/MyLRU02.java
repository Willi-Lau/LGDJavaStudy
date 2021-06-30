package com.lwy.java;


import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/30 19:19
 *    实现原理：
 *      lru里维护四个
 *                  一个是一个hashmap<Object,Node<object,object>>
 *                  一个是一个双向链表 list<Node>
 *                  一个坑位阈值
 *                  一个Node
 *
 *                  hashmap 用来 存储数据 查询数据
 *                  list 保证顺序  每次执行添加，或者查询 都把对应的node 移动到最前面 这样可以保证最后一个是最不被使用的
 *
 *
 *
  * @Param: null
 * @return
 */
public class MyLRU02 {

    private Integer flag;

    public MyLRU02(Integer flag){
        this.flag = flag;
    }

    //节点
    class Node<k,v>{
         Node prev,next;
         Object key,value;
         public Node(Object key,Object value){
             this.key = key;
             this.value = value;
         }

         public Object getValue(Object key){
             return value;
         }

    }
    //双向链表
    class DoubleLinkedList<y>{
        Node head,end;

        public DoubleLinkedList() {
            this.head = null;
            this.end = null;
            this.head.next = this.end;
            this.end.prev = this.head;
        }

        //添加元素到头
        public void put(Node node){
            if(this.head == null ){  // 空
                this.head = node;
                this.end = node;
            }
            else {
                this.head.prev = node;
                node.next = this.head;
                this.head = node;
            }

        }

        //删除元素
        public  void del(Node node){
            if(node == this.end && this.end != this.head){
                this.end.prev = this.end;
            }
            else if(node == this.head&& this.end != this.head ){
                this.head = this.head.next;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

        }

        //获取元素
        public Object get(Object key){
            Node flag = this.head;
            while (flag.next != this.end){
                if(key == flag.key){
                    return flag.value;
                }
                else {
                    flag = flag.next;
                }
            }
            return null;
        }

        //获取最后一个元素
        public Node getLast(){
            return this.end;
        }
    }

    DoubleLinkedList<Integer> list = new DoubleLinkedList();
    HashMap<Integer,Node<Integer,Integer>> map = new HashMap();

    public Integer get(Integer key){
        //查看有没有
        if(!map.containsKey(key)){
            return -1;
        }
        else {
            //调整队列位置 调整到头
            Node node = new Node(key,list.get(key));
            list.del(node);
            list.put(node);
            return (Integer) node.value;
        }
    }

    public void put(Integer key,Integer value){
        //如果有就更新 没有在写
        if(map.containsKey(key)){   //已经有这个元素
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);

            list.del(node);
            list.put(node);
        }
        {
            if(map.size() == flag){   //坑位满了，需要删除元素
                Node last = list.getLast();
                list.del(last);
                map.remove(last.key);

            }
            else { //纯粹新增
                Node node= new Node(key,value);
                map.put(key,node);
                list.put(node);

            }
        }
    }




}
