package com.lwy.JVM;

import com.lwy2.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class StringGC {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(4,node3);
        ListNode node5 = new ListNode(5,node4);
        ListNode node6 = new ListNode(11,node5);
        ListNode node7 = new ListNode(6,node6);
        ListNode[] arr = solve(5,node7);
        for (ListNode a:arr){
            System.out.println("");
            while(a != null){
                System.out.print(a.val+" ");
                a = a.next;
            }
        }
    }

    public static ListNode[] solve (int k, ListNode a) {
        // write code here
        ListNode[] arr = new ListNode[k];
        ListNode[] record = new ListNode[k];
        while(a != null){
            ListNode sb = a;
            sb.next = null;
            int m = a.val % k;

            if( arr[m] == null){
                arr[m] = a;
                record[m] = a;
            }
            else{
                record[m].next = a;
                record[m] = a;
            }

            a = a.next;
        }

        return arr;
    }
}
