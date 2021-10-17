package com.lwy2.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(999999999);
        HashMap map = new HashMap();
        for (int i=0;i<100;i++){
            int finalI = i;
            new Thread(()->{
                map.put(finalI,1);
            }).start();
            new Thread(()->{
                System.out.println(map);
            }).start();
        }
    }
}
