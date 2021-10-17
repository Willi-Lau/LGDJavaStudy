package com.lwy2.didi;


import java.util.HashMap;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/7/24 21:36
 *
  * @Param: null
 * @return
 *
 * 一个node 存记录
 * 一个链表 管添加删除
 * 一个map 存数据
 * 然后判断等逻辑都在LRU大的类下面
 */
public class LRU {
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.add(1,1);
        lru.add(2,2);
        lru.add(3,3);
        lru.add(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }

    private Integer flag;

    public LRU(Integer flag) {
        this.flag = flag;
    }

    class Node{
         Object key, val;
         Node next;
         Node prev;

        public Node(Object key, Object val) {
            this.key = key;
            this.val = val;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object val) {
            this.val = val;
        }
    }

    class MyLinkedList{
        Node start = null,end = null;

        MyLinkedList(){

        }

        //添加
        public void add(Node node){
            if(start == null){
                this.start = node;
                this.end = node;
            }
            else{
                Node node1 = this.start;
                this.start = node;
                this.start.next = node1;
                node1.prev = this.start;
            }
        }
        //删除此节点
        public void remove(Node node){
            if(start == node){    //删除头
                this.start = this.start.next;
            }
            else if(end == node){   //删除尾巴
                Node prev = this.end.prev;
                prev.next = null;
                this.end = prev;
            }
            else {
                node.prev.next = node.next;
                node.next.prev =node.prev;
            }
        }
        //获取
        public Object get(Object key){
            Node node = this.start;
            while (node!= null){
                if(node.key.equals(key)){
                    return node.val;
                }
                node = node.next;
            }
            return null;
        }
        //返回最后一个元素
        public Node getEnd(){
            return end;
        }

    }

    HashMap<Object,Node> map = new HashMap();
    MyLinkedList linkedList = new MyLinkedList();

    public Object get(Object k){
        if(map.containsKey(k)){
            Node node = map.get(k);
            System.out.println(node.val);
            linkedList.remove(node);
            linkedList.add(node);
            return map.get(k);
        }
        else {
            return null;
        }
    }
    public void add(Object k,Object v){
        if(map.containsKey(k)){
            Node node = map.get(k);
            node.setVal(v);
        }
        else {
            if(map.size()<flag){
                Node node = new Node(k,v);
                linkedList.add(node);
                map.put(k,node);
            }
            else {
                Node end = linkedList.getEnd();
                linkedList.remove(end);
                map.remove(end.key);

                Node node = new Node(k,v);
                linkedList.add(node);
                map.put(k,node);
            }
        }



    }

}
