package com.lwy.JUC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentLinkedHashMapDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        //添加
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //获取
        Object poll = queue.poll();
        System.out.println(poll);

        Object poll2 = queue.poll();
        System.out.println(poll2);

        Object poll3 = queue.poll();
        System.out.println(poll3);

        HashMap hashMap = new HashMap();

        ArrayList list = new ArrayList();

        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
    }
}
