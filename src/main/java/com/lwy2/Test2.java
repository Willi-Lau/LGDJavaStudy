package com.lwy2;

import com.lwy2.entity.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Test2 {
    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node5 = new ListNode(5,node7);
        ListNode node3 = new ListNode(3,node5);
        ListNode node1 = new ListNode(1,node3);

        ListNode node8 = new ListNode(8);
        ListNode node6 = new ListNode(6,node8);
        ListNode node4 = new ListNode(4,node6);
        ListNode node2 = new ListNode(2,node4);

//        ListNode add = add(node1, node2);


        Solution_20210803.reorderList(node1);
//        while (node1!=null){
//            System.out.println(node1.val);
//            node1 = node1.next;
//        }

        System.out.println(Math.abs(-100));
    }

    public static ListNode add(ListNode node1,ListNode node2){
        ListNode head = node1;
        if (node1 != null && node2!= null){
            ListNode next1 = node1.next;
            ListNode next2 = node2.next;

            node1.next = node2;
            node2.next = add(next1,next2);
        }

        return head;
    }



}

class Solution_20210803 {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //找到中点 快慢指针法
        ListNode mid = find(head);
        //反转链表 反转中点后的部分
        ListNode root = reserve(mid);
        //拼接链表
        ListNode node1 = add(head,root);
        head = node1;
    }
    public static ListNode find(ListNode head){
        ListNode quick = head;
        ListNode slow = head;
        while(quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;    //最重要的一步 中节点的下一个设置为null 不然会死循环
        return next;
    }

    public static ListNode reserve(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;

    }

    public static  ListNode add(ListNode node1,ListNode node2){
        ListNode head = node1;
        if(node1 != null && node2 != null){
            ListNode next1 = node1.next;
            ListNode next2 = node2.next;
            node1.next = node2;
            node2.next = add(next1,next2);
        }
        return head;

    }


}
